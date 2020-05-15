package com.springbootvue.demo.Service.Impl;

import com.springbootvue.demo.Entity.Type;
import com.springbootvue.demo.NotFoundException;
import com.springbootvue.demo.Resp.TypeResp;
import com.springbootvue.demo.Service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeResp typeResp;

    @Override
    public List<Type> findAll() {
        return typeResp.findAll();
    }
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeResp.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeResp.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeResp.getTypeByName(name);
    }
    @Transactional
    @Override
    public Page<Type> listType(PageRequest pageRequest) {
        return typeResp.findAll(pageRequest);
    }

    @Override
    public List<Type> listType() {
        return null;
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        return null;
    }
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeResp.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeResp.save(t);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
            typeResp.deleteById(id);
    }
}
