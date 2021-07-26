package com.ivy.wiki.service;

import com.ivy.wiki.entiry.Ebook;
import com.ivy.wiki.resp.ResultVo;

import java.util.List;

/**
 * @author ivy
 */
public interface EbookService {
    /**
     * 分页查询电子书
     * @param name 模糊查询名，null为全部
     * @param pageNum 分页
     * @param size 分页
     * @return
     */
    public ResultVo findAll(String name, Integer pageNum, Integer size);

    /**
     * 添加电子书
     * @param ebook
     * @return
     */
    public ResultVo addEbook(Ebook ebook);

    /**
     * 删除电子书
     * @param ebook
     * @return
     */
    public ResultVo deleteEbook(Ebook ebook);

    /**
     * 更新电子书
     * @param ebook
     * @return
     */
    public ResultVo updateEbook(Ebook ebook);

    public ResultVo findEbookByCategory(String categoryId);
}
