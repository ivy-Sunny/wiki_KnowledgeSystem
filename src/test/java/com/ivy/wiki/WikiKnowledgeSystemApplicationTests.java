package com.ivy.wiki;

import com.ivy.wiki.entiry.Ebook;
import com.ivy.wiki.service.EbookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WikiKnowledgeSystemApplicationTests {

    @Autowired
    private EbookService ebookService;

    @Test
    void contextLoads() {
    }

}
