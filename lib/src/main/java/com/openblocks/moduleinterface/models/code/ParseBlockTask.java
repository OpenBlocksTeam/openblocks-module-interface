package com.openblocks.moduleinterface.models.code;

import java.util.ArrayList;

/**
 * This interface is used by the compiler to convert a block
 * opcode into java code
 */
public interface ParseBlockTask {
    /**
     * A function used to parse a block into code
     * TODO: An easier way to parse code to add stuff like imports
     * @param code The code
     * @param arguments The arguments given
     * @param childs_parsed_code Childs' parsed code if this block is a nested block
     */
    void parseBlock(StringBuilder code, ArrayList<String> arguments, String childs_parsed_code);
}
