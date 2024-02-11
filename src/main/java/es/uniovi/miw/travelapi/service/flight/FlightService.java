package es.uniovi.miw.travelapi.service.flight;

import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;
import es.uniovi.miw.travelapi.service.flight.dto.searchresult.FlightSearchResultDto;

import java.util.List;

public interface FlightService {

    List<AirportDto> searchAirports(String countryCode, String searchKeyWord);

    FlightSearchResultDto searchFlights(SearchFlightDto searchFlightDto);
}
