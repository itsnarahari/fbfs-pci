package com.fbfs.configs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerException extends RuntimeException{

    int statusCode;
    public CustomerException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
