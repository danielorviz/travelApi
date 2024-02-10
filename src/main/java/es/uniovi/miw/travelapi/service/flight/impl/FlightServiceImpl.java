package es.uniovi.miw.travelapi.service.flight.impl;

import es.uniovi.miw.travelapi.service.amadeus.AmadeusFlightsService;
import es.uniovi.miw.travelapi.service.amadeus.dto.AnalyticsDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.flight.FlightService;
import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import es.uniovi.miw.travelapi.util.CountryCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {


    @Autowired
    private AmadeusFlightsService amadeusFlightsService;

    @Cacheable(value = "searchAirportCache", key = "#countryCode + #searchKeyWord")
    @Override
    public List<AirportDto> searchAirports(String countryCode, String searchKeyWord) {
        List<AirportDto> airportsDto = new ArrayList<>();

        List<AFlightAirportDto> amadeusAirports = this.amadeusFlightsService.searchAirports(countryCode,searchKeyWord);

        amadeusAirports.forEach(ai -> airportsDto.add(new AirportDto(ai.getId(),ai.getName(),ai.getDetailedName(),ai.getIataCode(),
                CountryCodes.getByCountryCode(ai.getAddress().getCountryCode()),getTravelScore(ai.getAnalytics()))));
        return airportsDto;
    }

    private int getTravelScore(AnalyticsDto analyticsDto){
        if(analyticsDto!= null && analyticsDto.getTravelers()!=null){
            return analyticsDto.getTravelers().getScore();
        }
        return 0;
    }
}
