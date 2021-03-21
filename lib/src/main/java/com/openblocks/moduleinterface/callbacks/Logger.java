package com.openblocks.moduleinterface.callbacks;

import com.openblocks.moduleinterface.OpenBlocksModule;

/**
 * This interface is used by modules to log stuff, a class that implements this
 * interface will be provided on module initialize.
 *
 * The logs will be displayed on the Logs tab of OpenBlocks
 */
public interface Logger {
    void debug  (Class<? extends OpenBlocksModule> module_class, String text);
    void trace  (Class<? extends OpenBlocksModule> module_class, String text);
    void info   (Class<? extends OpenBlocksModule> module_class, String text);
    void warn   (Class<? extends OpenBlocksModule> module_class, String text);
    void err    (Class<? extends OpenBlocksModule> module_class, String text);
    void fatal  (Class<? extends OpenBlocksModule> module_class, String text);
}
