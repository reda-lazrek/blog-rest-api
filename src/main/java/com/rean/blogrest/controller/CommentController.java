package com.rean.blogrest.controller;

import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Comment;
import com.rean.blogrest.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiblog/comments")
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @GetMapping("/list")
    public List<Comment> getAllCategories(){
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCategoryById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }

    @PostMapping("/create")
    public Comment createCategory(@RequestBody Comment category){
        return commentService.createComment(category);
    }

    @PutMapping("/update/{id}")
    public Comment updateCategory(@PathVariable Long id, @RequestBody Comment newComment){
        return commentService.updateComment(id,newComment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
