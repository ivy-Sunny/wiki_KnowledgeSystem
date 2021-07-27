package com.ivy.wiki.service;

import com.ivy.wiki.resp.ResultVo;
import org.springframework.stereotype.Service;

/**
 * @author ivy
 */
@Service
public interface CategoryService {
    /**
     * 查询Category节点树
     * @return
     */
    public ResultVo findCategoryNodes();

    /**
     *  查询所有Category
     * @return
     */
    public ResultVo findAllCategory(String name);
}
