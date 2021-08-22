package pruebaPersonal.pruebaDTO.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pruebaPersonal.pruebaDTO.dto.CategoryDTO;
import pruebaPersonal.pruebaDTO.model.Category;
import pruebaPersonal.pruebaDTO.service.Impl.CategoryServiceImpl;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private MessageSource messageSource;


    @PostMapping("create")
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(categoryDTO);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("category/{id}")
    public Category findById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }

    @GetMapping("categoryAll")
    public List<String> findAll(){
        return categoryService.findAllName();
    }

    @PutMapping("categoryEdit/{id}")
    public ResponseEntity<String> edit(@RequestBody CategoryDTO categoryDTO ,@PathVariable("id") Long id){
        return categoryService.edit(id,categoryDTO);
    }



}
