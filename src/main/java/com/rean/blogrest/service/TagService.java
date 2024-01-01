package com.rean.blogrest.service;

import com.rean.blogrest.dto.AddTagRequest;
import com.rean.blogrest.model.Comment;
import com.rean.blogrest.model.Tag;

import java.util.List;

public interface TagService {
    void createTag(AddTagRequest tagRequest);
    Tag updateTag(Long id, Tag newTag);
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    void deleteTag(Long id);
}
