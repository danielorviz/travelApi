package es.uniovi.miw.travelapi.rest.flights;

import es.uniovi.miw.travelapi.rest.AbstractController;
import es.uniovi.miw.travelapi.service.flight.FlightService;
import es.uniovi.miw.travelapi.service.amadeus.dto.airport.AFlightAirportDto;
import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
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

    @GetMapping("search")
    public ResponseEntity<List<AirportDto>> search(@RequestParam("country") String country, @RequestParam("city") String city){

        return new ResponseEntity<>( this.flightService.searchAirports(country,city), HttpStatus.OK);
    }
}
