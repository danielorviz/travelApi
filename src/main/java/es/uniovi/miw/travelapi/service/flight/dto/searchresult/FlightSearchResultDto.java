package es.uniovi.miw.travelapi.service.flight.dto.searchresult;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FlightSearchResultDto implements Serializable{

    private int numberResults;

    private List<FlightResultDto> flights = new ArrayList<>();

}
