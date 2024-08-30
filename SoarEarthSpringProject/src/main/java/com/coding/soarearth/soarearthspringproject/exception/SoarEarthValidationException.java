package com.coding.soarearth.soarearthspringproject.exception;

public class SoarEarthValidationException extends RuntimeException {

    private final String errorCode;

    public SoarEarthValidationException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}