package com.vendas.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DomainExceptions extends RuntimeException {
        public DomainExceptions(String message){
            super(message);
        }

}
