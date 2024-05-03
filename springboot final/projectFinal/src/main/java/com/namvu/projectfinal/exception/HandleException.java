package com.namvu.projectfinal.exception;

import com.namvu.projectfinal.constrant.WrapResponseStatus;
import com.namvu.projectfinal.response.WrapResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public WrapResponse handleServiceException(ServiceException ex) {
        return WrapResponse.error(WrapResponseStatus.SERVICE_ERROR, ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName, errorMessage);
        });
        return handleExceptionInternal(ex, WrapResponse.error(WrapResponseStatus.BAD_REQUEST,errors.toString()), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public WrapResponse resourcedException(Exception ex) {
        return WrapResponse.error(WrapResponseStatus.INTERNAL_SERVER_ERROR, ex.getMessage() == null ?
                "Internal server error" : ex.getMessage());
    }
}
