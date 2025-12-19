package com.example.demo.exception; 
 
import java.time.LocalDateTime; 
import org.springframework.http.*; 
import org.springframework.web.bind.annotation.*; 
 
@RestControllerAdvice 
public class GlobalExceptionHandler { 
 
    @ExceptionHandler(ResourceNotFoundException.class) 
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException 
ex) { 
 
        ErrorResponse error = new ErrorResponse( 
            LocalDateTime.now(), 
            ex.getMessage(), 
            HttpStatus.NOT_FOUND.value() 
        ); 
 
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
    } 
 
@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.clas
s) 
    public ResponseEntity<Object> 
handleValidationErrors(org.springframework.web.bind.MethodArgumentNotValidException 
ex) { 
 
        String errorMsg = ex.getBindingResult() 
            .getFieldErrors() 
            .get(0) 
            .getDefaultMessage(); 
 
            ErrorResponse error = new ErrorResponse( 
                java.time.LocalDateTime.now(), 
                errorMsg, 
                HttpStatus.BAD_REQUEST.value() 
            ); 
 
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
    } 
} 