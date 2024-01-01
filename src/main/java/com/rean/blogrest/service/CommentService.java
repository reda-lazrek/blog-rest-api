package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddCommentRequest;
import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Comment;

import java.util.List;

public interface CommentService{
    void createComment(AddCommentRequest commentRequest);
    Comment updateComment(Long id, Comment newComment);
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    void deleteComment(Long id);
}
