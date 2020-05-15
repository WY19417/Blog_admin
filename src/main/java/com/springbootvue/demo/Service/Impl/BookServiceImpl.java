package com.springbootvue.demo.Service.Impl;

import com.springbootvue.demo.Entity.Book;
import com.springbootvue.demo.Resp.BookResp;
import com.springbootvue.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookResp bookResp;
    @Transactional
    @Override
    public List<Book> findAll() {
        return bookResp.findAll();
    }
    @Transactional
    @Override
    public Page<Book> findAll2(PageRequest pageRequest) {
        return bookResp.findAll(pageRequest);
    }
    @Transactional
    @Override
    public Book addBook(Book book) {
        return bookResp.save(book);
    }
    @Transactional
    @Override
    public Book select(Integer id) {
        return bookResp.findById(id).get();
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        bookResp.deleteById(id);
    }
}
