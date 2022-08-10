package com.bridgelab.greetingmessageapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class GreetingMessageAppException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

    public GreetingMessageAppException(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
