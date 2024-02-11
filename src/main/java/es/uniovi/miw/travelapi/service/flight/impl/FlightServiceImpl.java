package es.uniovi.miw.travelapi.service.flight.impl;

import es.uniovi.miw.travelapi.service.amadeus.AmadeusFlightsService;
import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AnalyticsDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.AFlightSearchDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.ItineraryDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.PriceDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.SegmentDto;
import es.uniovi.miw.travelapi.service.flight.FlightService;
import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;
import es.uniovi.miw.travelapi.service.flight.dto.searchresult.FlightItineraryDto;
import es.uniovi.miw.travelapi.service.flight.dto.searchresult.FlightResultDto;
import es.uniovi.miw.travelapi.service.flight.dto.searchresult.FlightSearchResultDto;
import es.uniovi.miw.travelapi.util.CountryCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public FlightSearchResultDto searchFlights(SearchFlightDto searchFlightDto) {
        FlightSearchResultDto result = new FlightSearchResultDto();

        List<AFlightSearchDto> amadeusFlights = this.amadeusFlightsService.searchFlights(searchFlightDto);


        amadeusFlights.forEach(af -> {
            FlightResultDto dto = new FlightResultDto();
            dto.setId(af.getId());
            dto.setPrice(getPrice(af.getPrice()));
            dto.setCurrency(getCurrency(af.getPrice()));
            dto.setDepartureDayItineraries(this.getItineraries(af.getItineraries(),searchFlightDto.getIataCodeOrigin()));
            dto.setReturnDayItineraries(this.getItineraries(af.getItineraries(),searchFlightDto.getIataCodeDestination()));

            result.getFlights().add(dto);
        });
        result.setNumberResults(result.getFlights().size());
        return result;
    }

    private String getCurrency(PriceDto priceDto) {
        if(priceDto != null){
            return priceDto.getCurrency();
        }
        return null;
    }

    private List<FlightItineraryDto> getItineraries(List<ItineraryDto> itineraries, final String codigoIATA) {
        List<FlightItineraryDto> result = new ArrayList<>();

        List<SegmentDto> segmentosFiltrados = itineraries.stream()
                .flatMap(itinerario -> itinerario.getSegments().stream())
                .filter(segmento -> segmento.getDeparture().getIataCode().equals(codigoIATA))
                .collect(Collectors.toList());

        FlightItineraryDto dto = new FlightItineraryDto();

        dto.setItinerary(segmentosFiltrados);
        result.add(dto);
        return result;
    }

    private double getPrice(PriceDto priceDto) {
        if(priceDto != null){
            return priceDto.getGrandTotal();
        }
        return 0;
    }
}
