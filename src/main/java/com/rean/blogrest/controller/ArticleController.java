package com.rean.blogrest.controller;

import com.rean.blogrest.model.*;
import com.rean.blogrest.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/apiblog/articles")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/list")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getArticleComments(@PathVariable Long id){
        Article article = articleService.getArticleById(id);
        return article.getComments();
    }

    @GetMapping("/{id}/categories")
    public Set<Category> getArticleCategories(@PathVariable Long id){
        Article article = articleService.getArticleById(id);
        return article.getCategories();
    }

    @PostMapping("/create")
    public Article createArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    @PutMapping("/update/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article newArticle){
        return articleService.updateArticle(id,newArticle);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }



}
