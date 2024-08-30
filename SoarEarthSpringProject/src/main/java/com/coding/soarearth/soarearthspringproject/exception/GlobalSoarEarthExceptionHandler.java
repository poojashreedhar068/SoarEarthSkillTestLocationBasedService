package com.coding.soarearth.soarearthspringproject.exception;

import com.coding.soarearth.soarearthspringproject.model.response.GenericErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.Instant;

@RestControllerAdvice
public class GlobalSoarEarthExceptionHandler {

    @ExceptionHandler(SoarEarthValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericErrorResponse> handleValidationException(SoarEarthValidationException ex, HttpServletRequest request) {
        GenericErrorResponse response = new GenericErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(Timestamp.from(Instant.now()));
        response.setPath(request.getContextPath());
        response.setMethod(request.getMethod());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<GenericErrorResponse> handleException(Exception ex,HttpServletRequest request) {
        GenericErrorResponse response = new GenericErrorResponse();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(ex.getMessage());
        response.setTimestamp(Timestamp.from(Instant.now()));
        response.setErrorMessage(ex.getMessage());
        response.setPath(request.getContextPath());
        response.setMethod(request.getMethod());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
