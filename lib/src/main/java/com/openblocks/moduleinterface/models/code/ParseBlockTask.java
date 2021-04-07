package com.openblocks.moduleinterface.models.code;

import java.util.ArrayList;

/**
 * This interface is used by the compiler to convert a block
 * opcode into java code
 */
public interface ParseBlockTask {
    void parseBlock(String code, ArrayList<String> arguments);
}
