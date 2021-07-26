package com.ivy.wiki.mapper;

import com.ivy.wiki.entiry.Ebook;
import org.apache.ibatis.annotations.*;

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

    /**
     * 添加电子书
     * @return
     * @param ebook
     */
    @Insert("INSERT INTO ebook(name, category1_id, category2_id, description, cover) " +
            "VALUES(#{name}, #{category1Id}, #{category2Id}, #{description}, #{cover})")
    public int insertEbook(Ebook ebook);

    /**
     * 删除电子书
     * @param id
     * @return
     */
    @Delete("DELETE FROM ebook WHERE id = #{id}")
    public int deleteEbook(Long id);

    /**
     * 更新电子书
     * @param ebook
     * @return
     */
    @Update("UPDATE ebook SET name=#{name}, category1_id=#{category1Id}, " +
            "category2_id=#{category2Id}, description=#{description}, cover=#{cover}" +
            "WHERE id = #{id}")
    public int updateEbook(Ebook ebook);
}
