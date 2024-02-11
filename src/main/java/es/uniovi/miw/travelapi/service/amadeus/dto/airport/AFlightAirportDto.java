package es.uniovi.miw.travelapi.service.amadeus.dto.airport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AFlightAirportDto {

    private String type;
    private String subType;
    private String name;
    private String detailedName;
    private String id;
    private String timeZoneOffset;
    private String iataCode;
    private GeoCodeDto geoCode;
    private AddressDto address;
    private AnalyticsDto analytics;
}
