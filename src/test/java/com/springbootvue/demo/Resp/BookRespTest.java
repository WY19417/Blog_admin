package com.springbootvue.demo.Resp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRespTest {
      @Autowired
      private BookResp bookResp;
      @Test
      void findAll(){
          System.out.println(bookResp.findAll());
      }
}