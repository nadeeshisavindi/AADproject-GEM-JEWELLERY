
package com.example.gemjewellery.exception;

import com.example.gemjewellery.dto.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = { AppException.class })
    public ResponseEntity<CommonResponse> handleAppException(AppException ex, WebRequest request) {
        log.warn("Handled application exception: {}", ex.getMessage());
        return ResponseEntity.ok(new CommonResponse(ex.getStatus(), ex.getMessage()));
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<CommonResponse> handleServerException(Exception ex, WebRequest request) {
        log.error("Unexpected error", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new CommonResponse(500, "UNEXPECTED_ERROR: " + ex.getMessage()));
    }
}
