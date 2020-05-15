package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Blog;
import com.springbootvue.demo.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/archive")
public class ArchiveController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/findAll")
    public Map<String, List<Blog>> findAll(){
        return blogService.archiveBlog();
    }
}
