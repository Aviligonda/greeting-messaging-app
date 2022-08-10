package com.bridgelab.greetingmessageapp.exception.exceptionhandling;

import com.bridgelab.greetingmessageapp.exception.GreetingMessageAppException;
import com.bridgelab.greetingmessageapp.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreetingMessageAppExceptionHandler {
    @ExceptionHandler(GreetingMessageAppException.class)
    public ResponseEntity<Response> handlerHiringException(GreetingMessageAppException messageAppException) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(messageAppException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
