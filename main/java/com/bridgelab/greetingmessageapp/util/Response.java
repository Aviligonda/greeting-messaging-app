package com.bridgelab.greetingmessageapp.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int errorCode;
    private String message;

    public Response() {
    }
}
