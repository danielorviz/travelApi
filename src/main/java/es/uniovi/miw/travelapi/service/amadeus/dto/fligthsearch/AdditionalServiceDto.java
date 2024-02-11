package es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalServiceDto {
    private String amount;
    private String type;
}
