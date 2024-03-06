package com.fbfs.configs;

import com.fbfs.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ApiError> handleException(CustomerException e) {
        return ResponseEntity.status(e.getStatusCode()).body(new ApiError(e.getMessage(), e.getStatusCode()));
    }
}
