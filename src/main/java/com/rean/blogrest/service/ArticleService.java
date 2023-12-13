package com.rean.blogrest.service;

import com.rean.blogrest.model.Article;

import java.util.List;

public interface ArticleService{
    Article createArticle(Article article);
    Article updateArticle(Long id,Article newArticle);
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    void deleteArticle(Long id);
}
