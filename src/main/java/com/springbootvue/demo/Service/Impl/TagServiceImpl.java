package com.springbootvue.demo.Service.Impl;

import com.springbootvue.demo.Entity.Tag;
import com.springbootvue.demo.NotFoundException;
import com.springbootvue.demo.Resp.TagResp;
import com.springbootvue.demo.Service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagResp tagResp;
    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagResp.save(tag);
    }
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagResp.findById(id).get();
    }
    @Transactional
    @Override
    public Tag getTagByName(String name) {
        return tagResp.findTagByName(name);
    }
    @Transactional
    @Override
    public Page<Tag> listTag(PageRequest pageRequest) {
        return tagResp.findAll(pageRequest);
    }
    @Transactional
    @Override
    public List<Tag> listTag() {
        return tagResp.findAll();
    }
    @Transactional
    @Override
    public List<Tag> listTagTop(Integer size) {
        return null;
    }
    @Transactional
    @Override
    public List<Tag> listTag(String ids) {
        return tagResp.findAllById(convertToList(ids));
    }
    //将字符串转化为数组
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag type) {
        Tag tag1=tagResp.findById(id).get();
        if (tag1 == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,tag1);
        return tagResp.save(tag1);
    }
    @Transactional
    @Override
    public void deleteTag(Long id) {
            tagResp.deleteById(id);
    }
}
