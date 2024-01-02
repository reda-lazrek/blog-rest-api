package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddArticleRequest;
import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Article;
import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Tag;
import com.rean.blogrest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void createArticle(AddArticleRequest articleRequest) {

        Article article = new Article();
        List<Category> articleCategories = new ArrayList<>();
        List<Tag> articleTags = new ArrayList<>();

        for (int categoryId: articleRequest.getCategoryIds()){
            Category category = categoryRepository.findById(categoryId).get();
            if (category!=null) articleCategories.add(category);
        }

        if (articleRequest.getTagLabels().isEmpty()){
            articleTags = null;
        }else {
            for (String tagLabel : articleRequest.getTagLabels()) {
                Optional<Tag> tag = tagRepository.findByName(tagLabel);
                if (tag.isPresent()) articleTags.add(tag.get());
                else {
                    Tag newTag = new Tag();
                    newTag.setName(tagLabel);
                    newTag.setArticles(null);
                    articleTags.add(newTag);
                    tagRepository.save(newTag);
                }
            }
        }

        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        article.setCategories(articleCategories);
        article.setTags(articleTags);
        article.setUser(userRepository.findById(articleRequest.getUserId()).get());
        article.setPublication_date(LocalDateTime.now());
        articleRepository.save(article);
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
        //return articleRepository.findAll();
        return articleRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(()-> new NotFoundException("Article not found with id: "+ id));
    }

    @Override
    public void deleteArticle(Long id) {
        Article article = articleRepository.findById(id).get();
        if (!article.getComments().isEmpty()){ //check if this article has comments
            for (int i = 0; i < article.getComments().size(); i++) {
                commentRepository.deleteById(article.getComments().get(i).getId());
            }
        }
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
