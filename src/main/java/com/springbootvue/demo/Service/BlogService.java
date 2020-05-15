package com.springbootvue.demo.Service;

import com.springbootvue.demo.Entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

public interface BlogService {
    List<Blog> findAll();
    //分页查询
    Page<Blog> findAll(PageRequest pageRequest);
    //查询
    Blog findbyId(long id);
    //增加
    Blog add(Blog blog);
    //删除
    void blogdelete(Long id);
    //修改
    Blog update(Blog blog);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();
}
