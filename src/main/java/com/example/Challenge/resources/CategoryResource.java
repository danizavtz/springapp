package com.example.Challenge.resources;

import com.example.Challenge.model.Category;
import com.example.Challenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/category")
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/listAll")
    public List<Category> listaCategorias(){
        return categoryRepository.findAll();
    }
}
