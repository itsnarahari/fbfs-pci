package com.fbfs.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiError {
    private String message;
    private int status;
}
