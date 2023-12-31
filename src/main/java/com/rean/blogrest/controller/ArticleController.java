package com.rean.blogrest.controller;

import com.rean.blogrest.dto.AddArticleRequest;
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
    public List<Category> getArticleCategories(@PathVariable Long id){
        Article article = articleService.getArticleById(id);
        return article.getCategories();
    }

    @GetMapping("/findByCategorie")
    public List<Article> getAllArticlesByCategoryName(@RequestParam(value = "categoryName") String categoryName){
        return articleService.getAllArticlesByCategoryName(categoryName);
    }

    @GetMapping("/findByTag")
    public List<Article> getAllArticlesByTagName(@RequestParam(value = "tagName") String tagName){
        return articleService.getAllArticlesByTagName(tagName);
    }

    @PostMapping("/create")
    public void createArticle(@RequestBody AddArticleRequest article){
         articleService.createArticle(article);
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
