package es.uniovi.miw.travelapi.rest.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {
    private String name;
    private String code;
}
