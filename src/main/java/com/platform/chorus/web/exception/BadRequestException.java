package com.platform.chorus.web.exception;

/**
 * Create by A.T on 2019/4/29
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
