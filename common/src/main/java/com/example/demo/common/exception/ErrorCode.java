package com.example.demo.common.exception;

/**
 * @auther suijinchi
 * @description 错误码
 * @date 2022/3/18
 */
public enum ErrorCode {

    SUCCESS(0),
    FAIL(12);

    private final long code;

    private ErrorCode(long code) {
        this.code = code;
    }

    public long getCode() {
        return this.code;
    }
}
