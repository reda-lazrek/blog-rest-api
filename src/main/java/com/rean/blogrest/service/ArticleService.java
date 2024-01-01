package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddArticleRequest;
import com.rean.blogrest.model.Article;

import java.util.List;

public interface ArticleService{
    void createArticle(AddArticleRequest articleRequest);
    Article updateArticle(Long id,Article newArticle);
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    void deleteArticle(Long id);
    List<Article> getAllArticlesByCategoryName(String categoryName);
    List<Article> getAllArticlesByTagName(String tagName);
}
