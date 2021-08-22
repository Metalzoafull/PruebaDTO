package pruebaPersonal.pruebaDTO.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pruebaPersonal.pruebaDTO.dto.CategoryDTO;
import pruebaPersonal.pruebaDTO.mapper.CategoryMapper;
import pruebaPersonal.pruebaDTO.model.Category;
import pruebaPersonal.pruebaDTO.repository.CategoryRepository;
import pruebaPersonal.pruebaDTO.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    public MessageSource messageSource;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO){
        Category entity;
        entity = categoryMapper.map(categoryDTO);
        categoryRepository.save(entity);
        return categoryDTO;

        /*}catch (Exception e){
            String notCreateMsg = messageSource.getMessage("no.valid",new Object[]{"Category"}, LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.OK, notCreateMsg);
        }

         */

    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);


    }


    @Override
    public boolean verify(String name) {
        return false;
    }


    @Override
    public List<CategoryDTO> findAllDto(){
        return categoryMapper.map(categoryRepository.findAll());
    }

    @Override
    public List<String> findAllName() {
        try{
            List<CategoryDTO> categoryDTOS = categoryMapper.map(categoryRepository.findAll());
            return categoryDTOS.stream()
                    .map(CategoryDTO::getName)
                    .collect(Collectors.toList());
        }catch (Exception e){
            String notListFound = messageSource.getMessage("no.list.found",new Object[]{"Category"},LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.OK,notListFound);
        }

    }

    @Override
    public void edit(Long id, CategoryDTO categoryDTO) {
        try {
            Category category = findById(id);
            if(categoryDTO.getName() != null){
                category.setName(categoryDTO.getName());
            }
            if(categoryDTO.getDescription() != null){
                category.setDescription(categoryDTO.getDescription());
            }
            if(categoryDTO.getImage() != null){
                category.setImage(categoryDTO.getImage());
            }
            categoryRepository.save(category);
        }catch (Exception e){
            String notFoundMsg = messageSource.getMessage("no.found", new Object[]{"Category"}, LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.OK, notFoundMsg);
        }


    }
}
