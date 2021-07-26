package com.ivy.wiki.service;

import com.ivy.wiki.resp.ResultVo;
import org.springframework.stereotype.Service;

/**
 * @author ivy
 */
@Service
public interface CategoryService {
    /**
     * 查询所有Category
     * @return
     */
    public ResultVo findAllCategory();
}
