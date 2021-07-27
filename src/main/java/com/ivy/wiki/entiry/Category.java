package com.ivy.wiki.entiry;

import lombok.Data;

import java.util.List;

/**
 * Category
 *
 * @Author: ivy
 * @CreateTime: 2021-07-25
 */
@Data
public class Category {
    private String id;
    private Integer parent;
    private String parentName;
    private String name;
    private Integer sort;
    private List<Category> children;
}
