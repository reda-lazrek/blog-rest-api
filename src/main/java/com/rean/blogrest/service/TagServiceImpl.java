package com.rean.blogrest.service;

import com.rean.blogrest.exception.NotFoundException;
import com.rean.blogrest.model.Comment;
import com.rean.blogrest.model.Tag;
import com.rean.blogrest.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Long id, Tag newTag){
        Optional<Tag> existingTag = tagRepository.findById(id);
        existingTag.get().setName(newTag.getName());
        return tagRepository.save(existingTag.get());
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElseThrow(()-> new NotFoundException("Tag not found with id: "+ id));

    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
