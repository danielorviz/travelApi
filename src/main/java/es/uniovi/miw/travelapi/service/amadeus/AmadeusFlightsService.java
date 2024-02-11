package es.uniovi.miw.travelapi.service.amadeus;

import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.AFlightSearchDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;

import java.util.List;

public interface AmadeusFlightsService {
    List<AFlightAirportDto> searchAirports(String countryCode, String searchKeyWord);

    List<AFlightSearchDto> searchFlights(SearchFlightDto searchFlightDto);
}
