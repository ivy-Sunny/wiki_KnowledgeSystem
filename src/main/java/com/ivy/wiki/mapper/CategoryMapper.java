package com.ivy.wiki.mapper;

import com.ivy.wiki.entiry.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ivy
 */
@Mapper
public interface CategoryMapper {
    /**
     * 查询CategoryNodes节点树
     * @return
     */
    public List<Category> findCategoryNodes();

    /**
     * 查询所有Category
     * @return
     */
    public List<Category> finAllCategory(String name);
}
