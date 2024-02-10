package es.uniovi.miw.travelapi.service.flight.dto;

import es.uniovi.miw.travelapi.rest.countries.dto.CountryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class AirportDto implements Serializable {

    private String id;
    private String name;
    private String detailedName;
    private String iataCode;
    private CountryDto countryDto;
    private int travelersScore;



}
