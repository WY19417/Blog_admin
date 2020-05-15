package com.springbootvue.demo.Service;


import com.springbootvue.demo.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Page<Book> findAll2(PageRequest pageRequest);

    Book addBook(Book book);

    Book select(Integer id);

    void delete(Integer id);
}
