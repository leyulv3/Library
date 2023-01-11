package com.example.book.util;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;


    public R() {
    }

    public R(ReturnCode message, T data) {
        this.code = message.getCode();
        this.message = message.getMessage();

        this.data = data;
    }

    public R(ReturnCode message) {
        this.code = message.getCode();
        this.message = message.getMessage();
    }


}

