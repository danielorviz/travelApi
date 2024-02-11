package es.uniovi.miw.travelapi.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FareDto implements Serializable {

    private String name;
    private String description;
}
