package es.uniovi.miw.travelapi.service.flight.dto.searchresult;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class FlightResultDto implements Serializable {
    private String id;

    private List<FlightItineraryDto> departureDayItineraries;
    private List<FlightItineraryDto> returnDayItineraries;

    private double price;
    private String currency;

    private double priceWithFare;
}
