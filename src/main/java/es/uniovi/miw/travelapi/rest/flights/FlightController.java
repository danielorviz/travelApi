package es.uniovi.miw.travelapi.rest.flights;

import es.uniovi.miw.travelapi.model.FareType;
import es.uniovi.miw.travelapi.model.IFareType;
import es.uniovi.miw.travelapi.rest.AbstractController;
import es.uniovi.miw.travelapi.rest.flights.dto.AirportResultDto;
import es.uniovi.miw.travelapi.rest.flights.dto.FareResultDto;
import es.uniovi.miw.travelapi.service.flight.FlightService;
import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.SearchFlightDto;
import es.uniovi.miw.travelapi.rest.flights.dto.FlightSearchResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flight/v1/")
public class FlightController extends AbstractController {

    @Autowired
    private FlightService flightService;

    @GetMapping("fares")
    public ResponseEntity<FareResultDto> getFares(){
        return new ResponseEntity<>(new FareResultDto(), HttpStatus.OK);
    }
    @GetMapping("airport/search")
    public ResponseEntity<AirportResultDto> searchAirports(@RequestParam("country") String country, @RequestParam("city") String city){

        List<AirportDto> airportDtos = this.flightService.searchAirports(country, city);

        return new ResponseEntity<>(new AirportResultDto(airportDtos.size(),airportDtos), HttpStatus.OK);
    }

    @GetMapping("flights/search")
    public ResponseEntity<FlightSearchResultDto> searchFlights(@RequestParam("originLocationCode") String originLocationCode,
                                                                     @RequestParam("destinationLocationCode") String destinationLocationCode,
                                                                     @RequestParam("departureDate") String departureDate,
                                                                     @RequestParam("returnDate") String returnDate,
                                                                     @RequestParam("adults") int adults,
                                                                     @RequestParam("max") int max,
                                                                     @RequestParam("fareType") FareType fareType){
        return new ResponseEntity<>( this.flightService.searchFlights( new SearchFlightDto(originLocationCode,destinationLocationCode,
                departureDate,returnDate,adults,max,fareType)), HttpStatus.OK);
    }

}
