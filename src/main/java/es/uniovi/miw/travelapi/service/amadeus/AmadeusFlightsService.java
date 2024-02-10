package es.uniovi.miw.travelapi.service.amadeus;

import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;

import java.util.List;

public interface AmadeusFlightsService {
    List<AFlightAirportDto> searchAirports(String countryCode, String searchKeyWord);
}
