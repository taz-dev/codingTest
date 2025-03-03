package com.hanteo.test.board.repository;

import com.hanteo.test.board.model.Category;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CategoryRepository {
    private final Map<Integer, Category> idMap; // 식별자 기반 검색
    private final Map<String, List<Category>> nameMap; // 이름 기반 검색
    private final Category root;
    private final Category anonymousBoard; // 익명게시판(공통)

    public CategoryRepository() {
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        root = new Category(0, "root");
        idMap.put(0, root);

        anonymousBoard = new Category(6, "익명게시판");
        idMap.put(6, anonymousBoard);
        nameMap.put("익명게시판", Collections.singletonList(anonymousBoard));
    }

    /* 카테고리 추가 */
    public void addCategory(int parentId, int childId, String name) {
        Category parent = idMap.get(parentId);
        if (parent == null) {
            parent = root;
        }

        Category child;
        if ("익명게시판".equals(name)) {
            child = anonymousBoard;
        } else {
            if (idMap.containsKey(childId)) {
                child = idMap.get(childId);
            } else {
                child = new Category(childId, name);
                idMap.put(childId, child);
            }

            if (!nameMap.containsKey(name)) {
                nameMap.put(name, new ArrayList<>());
            }
            nameMap.get(name).add(child);
        }

        parent.addChild(child);
    }

    /* 식별자 기반 검색 */
    public Category getCategoryById(int id) {
        return idMap.get(id);
    }

    /* 이름 기반 검색 */
    public List<Category> getCategoryByName(String name) {
        return nameMap.getOrDefault(name, new ArrayList<>());
    }

    public Category getRoot() {
        return root;
    }
}
