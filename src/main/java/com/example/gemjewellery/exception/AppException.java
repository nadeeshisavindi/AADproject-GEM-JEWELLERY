package com.example.gemjewellery.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppException extends RuntimeException {
    private int status;
    private String message;
}
