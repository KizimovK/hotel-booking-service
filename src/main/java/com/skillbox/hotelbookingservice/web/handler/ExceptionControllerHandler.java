package com.skillbox.hotelbookingservice.web.handler;

import com.skillbox.hotelbookingservice.dto.response.ExceptionResponse;
import com.skillbox.hotelbookingservice.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFound(EntityNotFoundException exception, WebRequest request){
        return buildExceptionResponse(exception, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse notValidException(MethodArgumentNotValidException exception, WebRequest request){
        return buildExceptionResponse(exception, request);
    }

    private ExceptionResponse buildExceptionResponse(Exception exception, WebRequest request) {
        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .description(request.getDescription(false))
                .build();
    }
}
