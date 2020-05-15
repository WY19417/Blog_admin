package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Tag;
import com.springbootvue.demo.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/findAll")
    public List<Tag> findAll(){
        return  tagService.listTag();
    }

    @RequestMapping("/findPage/{page}/{size}")
    public Page<Tag> findPage(@PathVariable("page")Integer page,
                              @PathVariable("size")Integer size ){
        PageRequest pageRequest = PageRequest.of(page,size);
        return tagService.listTag(pageRequest);
    }
    @RequestMapping("/find/{id}")
    public Tag findone(@PathVariable("id")Long id){
        return tagService.getTag(id);
    }
    @RequestMapping("/save")
    public String save(@RequestParam("name") String name){
        Tag result = tagService.getTagByName(name);
        if(result!=null){
            return "msgDuplicated";
        }else {
            Tag tag = new Tag();
            tag.setName(name);
            tagService.saveTag(tag);
            return "success";
        }
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id){
        tagService.deleteTag(id);
    }
}
