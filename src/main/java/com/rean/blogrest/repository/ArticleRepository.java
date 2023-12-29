package com.rean.blogrest.repository;

import com.rean.blogrest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findByCategories_NameContaining(String categoryName);

    List<Article> findByTags_NameStartingWith(String tagName);
}
