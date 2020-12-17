package com.chen.exception;

/**
 * @author CHEN
 * @date 2020/10/13  12:07
 */
public enum MyErrorCode{
    /**
     * 2001:没有找到用户!
     */
    NOT_FOND_USER(2001,"没有找到用户!"),
    /**
     * 3001:密码错误!
     */
    NO_ALLOW_LOGIN(3001,"密码错误!"),
    /**
     * 3002:密码修改失败!
     */
    PASSWORD_UPDATE_FAIL(3001,"密码错误!"),

    /**
     * 500:服务端异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?");

    private Integer code;
    private String message;

    MyErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
