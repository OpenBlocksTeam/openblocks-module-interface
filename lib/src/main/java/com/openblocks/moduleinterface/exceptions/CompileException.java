package com.openblocks.moduleinterface.exceptions;

/* When something wrong happened during compiling on PROJECT_COMPILER module, throw this */
public class CompileException extends Exception {
    public String message;

    public CompileException(String title, String message) {
        super(title);
        this.message = message;
    }
}
