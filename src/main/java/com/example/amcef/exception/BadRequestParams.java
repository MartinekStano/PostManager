package com.example.amcef.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestParams extends RuntimeException{
    public BadRequestParams(String message){super(message);}
}
