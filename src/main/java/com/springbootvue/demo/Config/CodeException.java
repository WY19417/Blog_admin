package com.springbootvue.demo.Config;

public class CodeException extends java.lang.Exception {
    private  static  String NO_MSG_EXIST = "信息不存在";

    public CodeException() {
    }

    public CodeException(String message) {
        super(message+NO_MSG_EXIST);
    }

}
