package com.example.Library.configuration;

import com.example.Library.exception.UserAlreadyExistedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//used to throw custom exception for API
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e){
//        return new ResponseEntity<>("Something went wrong, please try again", HttpStatus.BAD_REQUEST);
        Map<String,String> errorMap = new HashMap<>();
        for(FieldError error : e.getBindingResult().getFieldErrors()){
            errorMap.put(error.getField(),error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistedException.class)
    public ResponseEntity<?> handleException(UserAlreadyExistedException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
