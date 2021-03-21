package com.openblocks.moduleinterface.callbacks;

/**
 * This interface is used by modules to log stuff, a class that implements this
 * interface will be provided on module initialize.
 *
 * The logs will be displayed on the Logs tab of OpenBlocks
 */
public interface Logger {
    void debug  (Class<Object> module_class, String text);
    void trace  (Class<Object> module_class, String text);
    void info   (Class<Object> module_class, String text);
    void warn   (Class<Object> module_class, String text);
    void err    (Class<Object> module_class, String text);
    void fatal  (Class<Object> module_class, String text);
}
