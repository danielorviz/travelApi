package es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SegmentDto {
    private DepartureDto departure;
    private ArrivalDto arrival;
    private String carrierCode;
    private String number;
    private String duration;
    private String id;
    private int numberOfStops;
    private boolean blacklistedInEU;
}
