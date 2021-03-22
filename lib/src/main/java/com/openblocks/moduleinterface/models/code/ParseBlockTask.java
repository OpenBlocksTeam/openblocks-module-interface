package com.openblocks.moduleinterface.models.code;

/**
 * This interface is used by the compiler to convert a block
 * opcode into java code
 */
public interface ParseBlockTask {
    void parseBlock(String code);
}
