package api.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {

    private String id;
    private String idBoard;
    private String idList;
    private String name;
}
