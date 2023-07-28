package com.blogapi.exceptions;

import com.blogapi.payload.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private long id;

    public ResourceNotFoundException(long id){
        super("Resource Not Found Fot Id Number : "+id);
    }


}
