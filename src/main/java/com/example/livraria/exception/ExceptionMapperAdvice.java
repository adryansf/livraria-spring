package com.example.livraria.exception;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@RestControllerAdvice
class ExceptionMapperAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorBody handleNotFoundException(NotFoundException e) {
        return new ErrorBody(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorBody handleInvalidOperationException(InvalidOperationException e) {
        return new ErrorBody(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}