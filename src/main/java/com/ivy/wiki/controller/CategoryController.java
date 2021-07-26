package com.ivy.wiki.controller;

import com.ivy.wiki.resp.ResultVo;
import com.ivy.wiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-25
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/query")
    public ResultVo findCategory() {

        return new ResultVo<>(categoryService.findAllCategory());
    }
}
