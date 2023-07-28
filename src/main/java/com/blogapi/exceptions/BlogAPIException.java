package com.blogapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BlogAPIException extends RuntimeException{


    public BlogAPIException(HttpStatus httpStatus, String invalidJwtToken) {

    }
}
