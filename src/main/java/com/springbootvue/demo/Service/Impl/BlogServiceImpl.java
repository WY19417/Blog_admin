package com.springbootvue.demo.Service.Impl;

import com.springbootvue.demo.Config.CodeException;
import com.springbootvue.demo.Entity.Blog;
import com.springbootvue.demo.Resp.BlogResp;
import com.springbootvue.demo.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogResp blogResp;

    @Override
    public List<Blog> findAll() {
        return blogResp.findAll();
    }

    @Override
    public Page<Blog> findAll(PageRequest pageRequest) {
        return blogResp.findAll(pageRequest);
    }
    @Transactional
    @Override
    public Blog findbyId(long id){
        Optional<Blog> optional = Optional.of(blogResp.findById(id).get());
        if(optional!=null&&optional.isPresent()){
            return optional.get();
        }else {
            return null;
        }

    }
    @Transactional
    @Override
    public Blog add(Blog blog){
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        return blogResp.save(blog);
    }
    @Transactional
    @Override
    public void blogdelete(Long id) {
       blogResp.deleteById(id);
    }
    @Transactional
    @Override
    public Blog update(Blog blog) {
        Blog blog2 = new Blog();
        blog2.setUpdateTime(new Date());
        return blogResp.save(blog);
    }
    @Transactional
    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogResp.findGroupYear();
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : years) {
            map.put(year, blogResp.findByYear(year));
        }
        return map;
    }

    @Override
    public Long countBlog() {
        return blogResp.count();
    }


}
