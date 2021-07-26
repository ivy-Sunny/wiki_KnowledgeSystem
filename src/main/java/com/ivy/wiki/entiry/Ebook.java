package com.ivy.wiki.entiry;

import lombok.Data;

/**
 * @author ivy
 */
@Data
public class Ebook {
    private Long id;

    private String name;

    private String category1Id;

    private String category2Id;

    private String description;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;
}
