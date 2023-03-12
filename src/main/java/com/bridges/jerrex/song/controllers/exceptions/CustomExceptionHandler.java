package com.bridges.jerrex.song.controllers.exceptions;

import com.bridges.jerrex.song.responses.Meta;
import com.bridges.jerrex.song.responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response> handleNotFoundException(Exception e) {
        Response response = new Response(
                new Meta(HttpStatus.NOT_FOUND.value(), e.getMessage())
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
