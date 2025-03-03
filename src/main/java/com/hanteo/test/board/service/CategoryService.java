package com.hanteo.test.board.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hanteo.test.board.model.Category;
import com.hanteo.test.board.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /* 카테고리 추가 */
    public void addCategory(int parentId, int childId, String name) {
        categoryRepository.addCategory(parentId, childId, name);
    }

    /* 식별자 기반 검색 */
    public Category getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }

    /* 이름 기반 검색 */
    public List<Category> getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    /* json 형식으로 변환 */
    public String getCategoryAsJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(categoryRepository.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
