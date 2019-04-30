package com.platform.chorus.web.model;

/**
 * Create by A.T on 2019/4/30
 */
public class SuccessBody extends ResponseBody {
    private Object result = null;

    public SuccessBody(String message, Object result) {
        super(message);
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
