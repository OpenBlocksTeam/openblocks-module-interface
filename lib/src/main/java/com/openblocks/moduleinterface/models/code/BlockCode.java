package com.openblocks.moduleinterface.models.code;

import java.util.ArrayList;

/**
 * This class is used to store a block of operation
 *
 * opcode a key of {@link com.openblocks.moduleinterface.projectfiles.OpenBlocksCode#code_templates}
 * that will give you the format of the code that should be written.
 *
 * parameters are the string that should be formatted to the value / format of that opcode key in
 * {@link com.openblocks.moduleinterface.projectfiles.OpenBlocksCode#code_templates}
 */
public class BlockCode {
    public String opcode;
    public ArrayList<String> parameters;

    public BlockCode(String opcode, ArrayList<String> parameters) {
        this.opcode = opcode;
        this.parameters = parameters;
    }
}
