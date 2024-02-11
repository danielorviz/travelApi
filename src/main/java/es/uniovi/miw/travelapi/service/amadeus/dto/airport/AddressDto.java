package es.uniovi.miw.travelapi.service.amadeus.dto.airport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String cityName;
    private String cityCode;
    private String countryName;
    private String countryCode;
    private String regionCode;
}
