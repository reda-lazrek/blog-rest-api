package com.rean.blogrest.service;

import com.rean.blogrest.model.Comment;
import com.rean.blogrest.model.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    Tag updateTag(Long id, Tag newTag);
    List<Tag> getAllTags();
    Tag getTagById(Long id);
    void deleteTag(Long id);
}
