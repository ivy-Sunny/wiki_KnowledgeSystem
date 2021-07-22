package com.ivy.wiki.service.impl;

import com.ivy.wiki.entiry.Ebook;
import com.ivy.wiki.mapper.EbookMapper;
import com.ivy.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * EbookServiceImpl
 *
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
@Service
public class EbookServiceImpl implements EbookService {
    @Resource
    private EbookMapper ebookMapper;

    @Override
    public List<Ebook> findAll(String name) {
        return ebookMapper.findAll(name);
    }
}
