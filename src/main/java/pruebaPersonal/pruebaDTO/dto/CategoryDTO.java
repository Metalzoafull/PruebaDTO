package pruebaPersonal.pruebaDTO.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategoryDTO implements Serializable {

    private String name ;
    private String description;
    private String image;


}