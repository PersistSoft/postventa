package com.persist.postventa.rest.enums;

public enum CodeResponseEnum {
    ERROR(-1,"Error"),
    ALERT(0,"Alert"),
    SUCCESS(1,"Success");

    private Integer code;
    private String  message;

    CodeResponseEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
