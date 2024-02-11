package es.uniovi.miw.travelapi.service.flight;

import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;
import es.uniovi.miw.travelapi.rest.flights.dto.FlightSearchResultDto;

import java.util.List;

public interface FlightService {

    List<AirportDto> searchAirports(String countryCode, String searchKeyWord);

    FlightSearchResultDto searchFlights(SearchFlightDto searchFlightDto);
}
