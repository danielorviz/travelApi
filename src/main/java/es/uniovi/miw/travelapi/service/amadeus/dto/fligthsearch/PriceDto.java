package es.uniovi.miw.travelapi.service.amadeus.dto.fligthsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto {
    private String currency;
    private double total;
    private String base;
    private double grandTotal;
    private List<AdditionalServiceDto> additionalServices;
}
