package com.skillbox.hotelbookingservice.web.handler;

import com.skillbox.hotelbookingservice.dto.response.ExceptionResponse;
import com.skillbox.hotelbookingservice.dto.response.ExceptionValidResponse;
import com.skillbox.hotelbookingservice.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public ExceptionValidResponse notValidException(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        ExceptionValidResponse exceptionValidResponse = new ExceptionValidResponse();
        bindingResult.getFieldErrors().forEach(fieldError ->
                    exceptionValidResponse.addValidResponse(buildValidResponse(fieldError)));
        return exceptionValidResponse;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse overException(EntityNotFoundException exception, WebRequest request){
        return buildExceptionResponse(exception, request);
    }

    private ExceptionResponse buildExceptionResponse(Exception exception, WebRequest request) {
        return ExceptionResponse.builder()
                .message(exception.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    private ExceptionValidResponse.ValidResponse buildValidResponse(FieldError fieldError){
        return ExceptionValidResponse.ValidResponse.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }
}
