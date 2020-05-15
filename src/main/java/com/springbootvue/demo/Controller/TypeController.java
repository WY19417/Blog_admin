package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Type;
import com.springbootvue.demo.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("/findAll")
    public List<Type> findAll(){
        return  typeService.findAll();
    }
    @GetMapping("/types/{page}/{size}")
    public Page<Type> types(@PathVariable("page")Integer page,
                            @PathVariable("size")Integer size) {
        PageRequest pageRequest =PageRequest.of(page,size);
        return  typeService.listType(pageRequest);
    }
    @GetMapping("/find/{id}")
    public Type editInput(@PathVariable Long id) {
        return typeService.getType(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
     typeService.deleteType(id);
    }
    @RequestMapping("/save1")
    public String add(@RequestBody Type type){
        Type result = typeService.saveType(type);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }
    @RequestMapping("/save")
    public String save(@RequestParam("name")String name){
        Type type = typeService.getTypeByName(name);
        if(type!=null){
            return "该分类已存在";
        }else {
            Type type1 = new Type();
            type1.setName(name);
            typeService.saveType(type1);
            return "success";
        }
    }



}
