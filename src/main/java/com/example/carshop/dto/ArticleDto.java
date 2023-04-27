package com.example.carshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {
    private String title;
    private String content;
    private String author;
    private Long categoryId;
}
