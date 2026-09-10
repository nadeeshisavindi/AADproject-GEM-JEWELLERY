package com.example.gemjewellery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private int status;   // 0 = success, non-zero = error code
    private Object body;
    private String message;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
