package com.chen.exception;


/**
 * @author CHEN
 * @date 2020/10/13  18:28
 * 自定义异常
 */
public class MyException extends RuntimeException {
    Integer code;
    String message;

    public MyException(Integer code, String message) {

        this.code = code;
        this.message = message;

    }
    public MyException(MyErrorCode myErrorCode) {

        this.code = myErrorCode.getCode();
        this.message = myErrorCode.getMessage();

    }



    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
