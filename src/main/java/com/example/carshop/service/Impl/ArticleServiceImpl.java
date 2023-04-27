package com.example.carshop.service.Impl;

import com.example.carshop.controller.dto.ArticleDto;
import com.example.carshop.model.Article;
import com.example.carshop.repository.ArticleRepository;
import com.example.carshop.service.ArticleService;
import com.example.carshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryService categoryService;
    @Override
    public Article addArticle(ArticleDto articleDto) throws Exception {
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setAuthor(articleDto.getAuthor());
        article.setCategory(categoryService.getById(articleDto.getCategoryId()));
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Long id, ArticleDto articleDto) throws Exception {
        Article article = articleRepository.findById(id).orElseThrow();
        if(id != null){
            article.setTitle(articleDto.getTitle());
            article.setContent(articleDto.getContent());
            article.setAuthor(articleDto.getAuthor());
            article.setCategory(categoryService.getById(articleDto.getCategoryId()));
        }
        return articleRepository.save(article);
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> getAllArticles() throws Exception {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) throws Exception {
        return articleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Article> getArticlesForCategory(Long categoryId) throws Exception {
        return articleRepository.getArticlesByCategory_Id(categoryId);
    }

    @Override
    public List<Article> findByTitleContaining(String keyword) throws Exception {
        return articleRepository.findAllByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Article> findByAuthor(String author) throws Exception {
        return articleRepository.findAllByAuthorContainingIgnoreCase(author);
    }
}
