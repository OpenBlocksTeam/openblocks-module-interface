package com.openbloks.communicator.exceptions;

public class CompileException extends Exception {
    public String message;

    public CompileException(String title, String message) {
        super(title);
        this.message = message;
    }
}
