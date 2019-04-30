package com.platform.chorus.web.model;

/**
 * Create by A.T on 2019/4/30
 */
public class ErrorBody extends ResponseBody{
    private String cause = null;
    private Integer code = null;

    public ErrorBody(String message, String cause, Integer code) {
        super(message);
        this.cause = cause;
        this.code = code;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
