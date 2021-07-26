package com.ivy.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ivy.wiki.entiry.Ebook;
import com.ivy.wiki.mapper.EbookMapper;
import com.ivy.wiki.resp.ResultVo;
import com.ivy.wiki.service.EbookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * EbookServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
@Service
@Transactional
public class EbookServiceImpl implements EbookService {
    @Resource
    private EbookMapper ebookMapper;

    @Override
    public ResultVo findAll(String name, Integer pageNum, Integer size) {
        if (pageNum == null || size == null) {
            return new ResultVo(ebookMapper.findAll(name));
        } else {
            PageHelper.startPage(pageNum, size);
            PageInfo pageInfo = new PageInfo(ebookMapper.findAll(name));
            return new ResultVo(pageInfo);
        }
    }

    @Override
    public ResultVo addEbook(Ebook ebook) {
        int result = ebookMapper.insertEbook(ebook);
        if (result == 1) {
            return new ResultVo(200, "添加电子书成功");
        } else {
            return new ResultVo(400, "添加失败");
        }
    }

    @Override
    public ResultVo deleteEbook(Ebook ebook) {
        Long id = ebook.getId();
        int result = ebookMapper.deleteEbook(id);
        if (result == 1) {
            return new ResultVo(200, "删除电子书成功");
        } else {
            return new ResultVo(400, "删除失败");
        }
    }

    @Override
    public ResultVo updateEbook(Ebook ebook) {
        int result = ebookMapper.updateEbook(ebook);
        if (result == 1) {
            return new ResultVo(200, "删除电子书成功");
        } else {
            return new ResultVo(400, "删除失败");
        }
    }

    @Override
    public ResultVo findEbookByCategory(String categoryId) {
        System.err.println(categoryId);
        return new ResultVo(ebookMapper.listByCategory(categoryId));
    }
}
