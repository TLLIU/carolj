package com.tlliu.springboot.carolj.utils.execption;

import com.tlliu.springboot.carolj.dto.ResultDTO;
import com.tlliu.springboot.carolj.utils.StationError;

public class StationErrorCodeException extends Exception {
    private StationError errorCode;

    public StationErrorCodeException(StationError errorCode, Exception ex) {
        super(errorCode.getErrorMessage(), ex);
        this.errorCode = errorCode;
    }

    public StationErrorCodeException(StationError errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public StationError getErrorCode() {
        return errorCode;
    }

}