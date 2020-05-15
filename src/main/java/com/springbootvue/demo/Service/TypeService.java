package com.springbootvue.demo.Service;

import com.springbootvue.demo.Entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface TypeService {
    List<Type> findAll();
    //保存
    Type saveType(Type type);
    //查询
    Type getType(Long id);
    //通过种类获取名字
    Type getTypeByName(String name);
    //分页查询
    Page<Type> listType(PageRequest pageRequest);

    List<Type> listType();
    //查询前几个
    List<Type> listTypeTop(Integer size);
    //更新
    Type updateType(Long id,Type type);
    //删除
    void deleteType(Long id);
}
