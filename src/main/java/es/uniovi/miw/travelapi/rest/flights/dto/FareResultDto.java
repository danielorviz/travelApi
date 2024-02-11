package es.uniovi.miw.travelapi.rest.flights.dto;

import es.uniovi.miw.travelapi.model.FareDto;
import es.uniovi.miw.travelapi.model.FareType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class FareResultDto implements Serializable {

    private int numberResults;

    private List<FareDto> fares = new ArrayList<>();

    public FareResultDto(){
        Arrays.stream(FareType.values()).forEach( f ->{
            FareDto dto = new FareDto();
            dto.setName(f.name());
            dto.setDescription(f.getDescription());
            this.fares.add(dto);
        });
        this.numberResults = FareType.values().length;
    }
}
