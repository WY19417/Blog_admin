package com.springbootvue.demo.Resp;

import com.springbootvue.demo.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface TagResp extends JpaRepository<Tag,Long> {
    Tag findTagByName(String name);


    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
