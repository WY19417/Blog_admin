package com.springbootvue.demo.Service;

import com.springbootvue.demo.Entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    List<Comment> findAll();

    Page<Comment> findTop(PageRequest pageRequest);

    List<Comment> eachComment(List<Comment> comments);
}
