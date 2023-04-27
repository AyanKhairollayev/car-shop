package com.example.carshop.controller.dto;

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
