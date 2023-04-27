package com.example.carshop.controller;

import com.example.carshop.controller.dto.ArticleDto;
import com.example.carshop.model.Article;
import com.example.carshop.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("api/article/addarticle")
    public ResponseEntity<?> addArticle(@RequestBody ArticleDto articleDto) throws Exception{
        String name = articleService.addArticle(articleDto).getTitle();
        return ResponseEntity.ok().body("Article create - " + name);
    }

    @PutMapping("api/article/update/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody ArticleDto articleDto) throws Exception{
        return articleService.updateArticle(id,articleDto);
    }

    @DeleteMapping("api/article/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id){
        articleService.delete(id);
        return ResponseEntity.ok().body("Article del");
    }

    @GetMapping("api/articles")
    public List<Article> getAllArticles() throws Exception{
        return articleService.getAllArticles();
    }

    @GetMapping("api/article/{id}")
    public Article getArticleById(@PathVariable Long id) throws Exception{
        return articleService.getArticleById(id);
    }

    @GetMapping("api/article/getarticle/{categoryId}")
    public List<Article> getArticleForCategory(@PathVariable Long categoryId) throws Exception{
        return articleService.getArticlesForCategory(categoryId);
    }

    @GetMapping("api/article/search/title")
    public List<Article> getArticleByTitle(@RequestParam(required = false) String keyword) throws Exception{
        return articleService.findByTitleContaining(keyword);
    }

    @GetMapping("api/article/search/author")
    public List<Article> getArticleByAuthor(@RequestParam(required = false) String author) throws Exception{
        return articleService.findByAuthor(author);
    }
}
