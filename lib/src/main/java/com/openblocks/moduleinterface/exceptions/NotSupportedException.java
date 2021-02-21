package com.openblocks.moduleinterface.exceptions;

/* When a module doesn't support the method in the interface, throw this instead of returning null */
public class NotSupportedException extends Exception {
    public NotSupportedException(String reason) { super(reason); }
}
