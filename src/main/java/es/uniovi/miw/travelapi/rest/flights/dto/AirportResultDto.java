package es.uniovi.miw.travelapi.rest.flights.dto;

import es.uniovi.miw.travelapi.service.flight.dto.AirportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportResultDto implements Serializable {

    private int numberResults;
    private List<AirportDto> airports = new ArrayList<>();
}
