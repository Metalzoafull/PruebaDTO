package pruebaPersonal.pruebaDTO.service;

import pruebaPersonal.pruebaDTO.dto.CategoryDTO;
import pruebaPersonal.pruebaDTO.model.Category;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO categoryDTO);

    void delete(Long id);

    Category findById(Long id);

    boolean verify(String name);

    List<CategoryDTO> findAllDto();

    List<String> findAllName();

    void edit(Long id, CategoryDTO categoryDTO);
}
