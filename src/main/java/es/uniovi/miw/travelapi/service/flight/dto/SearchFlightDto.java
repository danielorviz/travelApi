package es.uniovi.miw.travelapi.service.flight.dto;

import es.uniovi.miw.travelapi.model.IFareType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightDto implements Serializable {

    private String iataCodeOrigin;
    private String iataCodeDestination;
    private String departureDate;
    private String returnDate;
    private int adults;
    private int maxResults;

    private IFareType fareType;
}
