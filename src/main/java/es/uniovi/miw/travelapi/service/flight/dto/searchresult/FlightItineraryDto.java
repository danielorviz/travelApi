package es.uniovi.miw.travelapi.service.flight.dto.searchresult;

import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.ItineraryDto;
import es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch.SegmentDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FlightItineraryDto implements Serializable{

    private List<SegmentDto> itinerary;

}
