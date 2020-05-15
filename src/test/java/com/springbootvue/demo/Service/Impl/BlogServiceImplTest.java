package com.springbootvue.demo.Service.Impl;

import com.springbootvue.demo.Resp.BlogResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BlogServiceImplTest {
    @Autowired
    private BlogResp blogResp;
    @Test
    void findAll() {
        System.out.printf("1");
    }
}