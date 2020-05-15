package com.springbootvue.demo.Resp;

import com.springbootvue.demo.Entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface TypeResp extends JpaRepository<Type,Long> {
    Type findByName(String name);


    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

    Type getTypeByName(String name);
}
