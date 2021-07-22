package com.ivy.wiki.controller;

import com.ivy.wiki.resp.ResultVo;
import com.ivy.wiki.service.EbookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/list",produces = "application/json")
    public ResultVo list(String name) {
        return new ResultVo<>(ebookService.findAll(name));
    }
}
