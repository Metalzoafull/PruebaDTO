package pruebaPersonal.pruebaDTO.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pruebaPersonal.pruebaDTO.dto.CategoryDTO;
import pruebaPersonal.pruebaDTO.model.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMapper {

    private ModelMapper modelMapper;

    @Autowired
    public CategoryMapper(ModelMapper modelMapper){this.modelMapper = modelMapper;}

    public Category map(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO map(Category category){
        return modelMapper.map(category, CategoryDTO.class);
    }

    public List<CategoryDTO> map(List<Category> categoryList){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryList.forEach(category -> categoryDTOList.add(map(category)));
        return categoryDTOList;
    }
}
