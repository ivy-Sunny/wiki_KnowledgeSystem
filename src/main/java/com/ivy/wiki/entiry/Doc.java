package com.ivy.wiki.entiry;

import lombok.Data;

@Data
public class Doc {
    private Long id;

    private Long ebookId;

    private Integer parent;

    private String name;

    private Integer sort;

    private Integer viewCount;

    private Integer voteCount;
}