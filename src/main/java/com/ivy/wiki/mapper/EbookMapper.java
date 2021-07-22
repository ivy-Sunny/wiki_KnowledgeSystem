package com.ivy.wiki.mapper;

import com.ivy.wiki.entiry.Ebook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ivy
 */
@Mapper
public interface EbookMapper {
    /**
     * 通过Ebook进行搜索
     *
     * @param ebook
     * @return
     */
    public List<Ebook> findEbook(Ebook ebook);

    /**
     * 查询所有Ebook
     *
     * @return
     */
    public List<Ebook> findAll(String name);
}
