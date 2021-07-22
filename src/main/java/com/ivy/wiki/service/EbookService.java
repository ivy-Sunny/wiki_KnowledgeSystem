package com.ivy.wiki.service;

import com.ivy.wiki.entiry.Ebook;

import java.util.List;

/**
 * @author ivy
 */
public interface EbookService {
    /**
     * 查询所有Ebook
     *
     * @return
     */
    public List<Ebook> findAll(String name);
}
