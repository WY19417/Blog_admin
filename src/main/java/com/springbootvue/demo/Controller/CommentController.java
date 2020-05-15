package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Comment;
import com.springbootvue.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/findAll")
    public List<Comment> findAll(){
        return  commentService.findAll();
    }
    @RequestMapping("/findtop")
    public Page<Comment> findtop(){
        Sort sort  = Sort.by(Sort.Direction.DESC,"createTime");
        PageRequest pageRequest = PageRequest.of(0,5,sort);
        return commentService.findTop(pageRequest);
    }
    @GetMapping("/comments/{blogId}")
    public List<Comment> comments(@PathVariable Long blogId) {
        return commentService.listCommentByBlogId(blogId);
    }
    @RequestMapping("/save")
    public String save(@RequestBody Comment comment){
      comment.setCreateTime(new Date());
      Comment comment1 = commentService.saveComment(comment);
        if(comment1!=null){
            return "success";
        }else {
            return "false";
        }
    }
}
