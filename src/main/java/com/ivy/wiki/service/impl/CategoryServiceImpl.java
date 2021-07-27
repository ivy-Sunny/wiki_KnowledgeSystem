package com.ivy.wiki.service.impl;

import com.ivy.wiki.entiry.Category;
import com.ivy.wiki.mapper.CategoryMapper;
import com.ivy.wiki.resp.ResultVo;
import com.ivy.wiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CategoryServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-25
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResultVo findCategoryNodes() {
        return new ResultVo(categoryMapper.findCategoryNodes());
    }

    @Override
    public ResultVo findAllCategory(String name) {
        return new ResultVo(categoryMapper.finAllCategory(name));
    }


}
