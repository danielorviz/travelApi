package es.uniovi.miw.travelapi.rest.countries;

import es.uniovi.miw.travelapi.rest.AbstractController;
import es.uniovi.miw.travelapi.rest.countries.dto.CountryDto;
import es.uniovi.miw.travelapi.rest.countries.dto.CountryResultDto;
import es.uniovi.miw.travelapi.util.CountryCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("countries/v1/")
public class CountriesController extends AbstractController {

    @GetMapping("all")
    public ResponseEntity<CountryResultDto> getCountries(){
        List<CountryDto> countries = CountryCodes.getPaises();

        return new ResponseEntity<>(new CountryResultDto(countries.size(),CountryCodes.getPaises()), HttpStatus.OK);
   }
}
