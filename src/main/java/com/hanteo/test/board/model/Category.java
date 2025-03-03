package com.hanteo.test.board.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Category {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("children")
    private Set<Category> children;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.children = new HashSet<>();
    }

    public void addChild(Category child) {
        this.children.add(child);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Category> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
