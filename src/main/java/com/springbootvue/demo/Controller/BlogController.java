package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Blog;
import com.springbootvue.demo.Service.BlogService;
import com.springbootvue.demo.Service.TagService;
import com.springbootvue.demo.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Blog> findAll(@PathVariable("page")Integer page,
                              @PathVariable("size")Integer size){
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return blogService.findAll(pageRequest);
    }
    @RequestMapping("/findAll")
    public List<Blog> findAll1(){
        return blogService.findAll();
    }
    @GetMapping("findone")
    public Blog findone(@RequestParam("id")Long id){
            return blogService.findbyId(id);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id")Long id){
        blogService.blogdelete(id);
    }
    @RequestMapping("/findtop")
    public Page<Blog> fintop(){
        Sort sort = Sort.by(Sort.Direction.DESC,"updateTime");
        PageRequest pageRequest = PageRequest.of(0,3,sort);
        return blogService.findAll(pageRequest);
    }
    @Scope("prototype")
    @RequestMapping("/save")
    public String save(@RequestBody Blog blog){
        Blog blog1 =blogService.add(blog);
        if (blog1!=null){
            return "success";
        }else {
            return "flase";
        }
    }

}
