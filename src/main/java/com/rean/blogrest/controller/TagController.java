package com.rean.blogrest.controller;

import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Tag;
import com.rean.blogrest.service.CategoryServiceImpl;
import com.rean.blogrest.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiblog/tags")
public class TagController {

    @Autowired
    TagServiceImpl tagService;

    @GetMapping("/list")
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable Long id){
        return tagService.getTagById(id);
    }

    @PostMapping("/create")
    public Tag createTag(@RequestBody Tag tag){
        return tagService.createTag(tag);
    }

    @PutMapping("/update/{id}")
    public Tag updateTag(@PathVariable Long id, @RequestBody Tag newTag){
        return tagService.updateTag(id,newTag);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
    }

}
