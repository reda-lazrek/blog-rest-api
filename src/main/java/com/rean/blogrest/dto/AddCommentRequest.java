package com.rean.blogrest.dto;


import lombok.Data;



@Data
public class AddCommentRequest {
    private String content;
    private Long articleId;
}
