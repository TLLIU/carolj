package com.tlliu.springboot.carolj.utils;

public enum StationError {
    STA10001(1, "Code Error 001"),
    STA10002(2, "Code Error 002");
    private int errorCode;
    private String errorMessage;
    private StationError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
