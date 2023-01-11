package com.example.book.util;

public enum ReturnCode {
    /**操作成功**/
    SUCCESS(200,"操作成功"),
    /**操作失败**/
    ERROR(999,"操作失败");
    /**服务限流**/


    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}