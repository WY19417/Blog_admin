package com.springbootvue.demo.Resp;

import com.springbootvue.demo.Entity.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentResp extends JpaRepository<Comment,Long>{
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
