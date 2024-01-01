package com.rean.blogrest.dto;

import com.rean.blogrest.model.Category;
import com.rean.blogrest.model.Comment;
import com.rean.blogrest.model.Tag;
import lombok.Data;
import java.util.List;

@Data
public class AddArticleRequest {

    private String title;

    private String content;

    private List<Integer> categoryIds;

    private List<String> tagLabels;

    private Long userId;
}
