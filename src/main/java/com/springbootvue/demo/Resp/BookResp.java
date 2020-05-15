package com.springbootvue.demo.Resp;

import com.springbootvue.demo.Entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookResp extends JpaRepository<Book,Integer> {

}
