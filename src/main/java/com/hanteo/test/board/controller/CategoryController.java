package com.hanteo.test.board.controller;

import com.hanteo.test.board.model.Category;
import com.hanteo.test.board.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam int parentId, @RequestParam int childId, @RequestParam String name) {
        categoryService.addCategory(parentId, childId, name);
        return "success";
    }

    @GetMapping("/list")
    public String getCategoryList() {
        return categoryService.getCategoryAsJson();
    }

    @GetMapping("/id/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public List<Category> getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}
