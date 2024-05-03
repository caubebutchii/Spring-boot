package com.namvu.buoi4.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Class để bắt tất cả các lỗi của chương trình
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }


}
