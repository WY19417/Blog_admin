package com.springbootvue.demo.Controller;

import com.springbootvue.demo.Entity.Book;
import com.springbootvue.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
public class Controller {
    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public List<Book> index(){
        return bookService.findAll();
    }
    @RequestMapping("/findAll/{page}/{size}")
    public Page<Book> page(@PathVariable("page")Integer page,
                           @PathVariable("size")Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return bookService.findAll2(pageRequest);
    }
    @RequestMapping("/save")
    public String add(@RequestBody Book book){
        Book result = bookService.addBook(book);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }
    @RequestMapping("/select/{id}")
    public Book select(@PathVariable("id")Integer id){
        return bookService.select(id);
    }
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookService.addBook(book);
        if(result !=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id")Integer id){
        bookService.delete(id);
    }
}
