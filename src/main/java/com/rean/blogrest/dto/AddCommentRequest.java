package com.rean.blogrest.dto;

import com.rean.blogrest.model.Article;

import lombok.Data;



@Data
public class AddCommentRequest {
    private String content;
    private Long articleId;
}
