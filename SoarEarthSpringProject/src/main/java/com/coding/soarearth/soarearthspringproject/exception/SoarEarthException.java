package com.coding.soarearth.soarearthspringproject.exception;

public class SoarEarthException extends RuntimeException {

    private final String errorCode;

    public SoarEarthException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}