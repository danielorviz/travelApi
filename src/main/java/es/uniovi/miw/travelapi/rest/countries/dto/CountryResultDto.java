package es.uniovi.miw.travelapi.rest.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryResultDto implements Serializable {

    private int numberResults;

    private List<CountryDto> countries = new ArrayList<>();
}
