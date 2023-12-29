package com.rean.blogrest.service;

import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Article;
import com.rean.blogrest.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        article.setPublication_date(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Long id,Article newArticle) {
        Optional<Article> existingArticle = articleRepository.findById(id);
        existingArticle.get().setContent(newArticle.getContent());
        existingArticle.get().setTitle(newArticle.getTitle());
        return articleRepository.save(existingArticle.get());
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(()-> new NotFoundException("Article not found with id: "+ id));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> getAllArticlesByCategoryName(String categoryName) {
        return articleRepository.findByCategories_NameContaining(categoryName);
    }

    @Override
    public List<Article> getAllArticlesByTagName(String tagName) {
        return articleRepository.findByTags_NameStartingWith(tagName);
    }
}
