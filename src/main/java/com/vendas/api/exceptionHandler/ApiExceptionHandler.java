package com.vendas.api.exceptionHandler;

import com.vendas.domain.exceptions.DomainExceptions;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DomainExceptions.class)
    public ResponseEntity<String> capturar(DomainExceptions e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
