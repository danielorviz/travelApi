package es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartureDto {
    private String iataCode;
    private Date at;
    private String terminal;
}
