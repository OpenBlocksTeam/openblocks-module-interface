package com.openblocks.moduleinterface.exceptions;

/**
 * This exception is used when the Parser module failed
 * to parse something
 */
public class ParseException extends Exception {
    public ParseException(String error) {
        super(error);
    }
}
