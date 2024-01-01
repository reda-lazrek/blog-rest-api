package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddCommentRequest;
import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Comment;
import com.rean.blogrest.repository.ArticleRepository;
import com.rean.blogrest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ArticleRepository articleRepository;


    @Override
    public void createComment(AddCommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setDate(LocalDateTime.now());
        comment.setContent(commentRequest.getContent());
        comment.setArticle(articleRepository.findById(commentRequest.getArticleId()).get());
        commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, Comment newComment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        existingComment.get().setContent(newComment.getContent());
        return commentRepository.save(existingComment.get());
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(()-> new NotFoundException("Comment not found with id: "+ id));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
