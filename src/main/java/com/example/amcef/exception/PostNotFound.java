package com.example.amcef.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PostNotFound extends RuntimeException{
    public PostNotFound(String message){super(message);}
}
