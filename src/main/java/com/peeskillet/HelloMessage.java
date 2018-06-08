package com.peeskillet;

import javax.validation.constraints.Size;


public class HelloMessage {

    @Size(max = 100, min = 2)
    private String message;

    public HelloMessage() {}

    public HelloMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
