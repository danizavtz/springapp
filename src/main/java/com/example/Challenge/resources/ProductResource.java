package com.example.Challenge.resources;

import com.example.Challenge.model.Product;
import com.example.Challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/product")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/listByCategory/{categoryId}")
    public List<Product> listProductByCategory(@PathVariable("categoryId") Long categoryId) {
        return productRepository.listByCategory(categoryId);
    }
}
