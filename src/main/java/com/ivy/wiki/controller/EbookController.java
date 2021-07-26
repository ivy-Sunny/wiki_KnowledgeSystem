package com.ivy.wiki.controller;

import com.ivy.wiki.entiry.Ebook;
import com.ivy.wiki.resp.ResultVo;
import com.ivy.wiki.service.EbookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * EbookController
 *
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;

    @GetMapping(value = "/list")
    public ResultVo list(String name, Integer page, Integer size) {
        return ebookService.findAll(name, page, size);
    }

    @PostMapping("/add")
    public ResultVo add(@RequestBody Ebook ebook) {
        return ebookService.addEbook(ebook);
    }

    @PostMapping("/edit")
    public ResultVo edit(@RequestBody Ebook ebook) {

        return ebookService.updateEbook(ebook);
    }

    @PostMapping("/del")

    public ResultVo delete(@RequestBody Ebook ebook) {
        return ebookService.deleteEbook(ebook);
    }
}
