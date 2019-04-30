package com.platform.chorus.web.model;

/**
 * Create by A.T on 2019/4/30
 */
public abstract class ResponseBody {
    protected String message = null;

    public ResponseBody(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
