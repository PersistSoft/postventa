package com.persist.postventa.exception;

import com.persist.postventa.exceptions.ServiceException;
import com.persist.postventa.rest.response.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GenericControllerAdvice<T>  {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> handlerRuntimeExceptionNotFound(RuntimeException ex) {
        ErrorDto error = ErrorDto.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<ErrorDto>(error, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handlerExceptionNotFound(ServiceException ex) {
        ErrorDto error = ErrorDto.builder().code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<ErrorDto>(error, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
}
