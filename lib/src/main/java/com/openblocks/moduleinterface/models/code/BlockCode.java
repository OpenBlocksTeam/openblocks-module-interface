package com.openblocks.moduleinterface.models.code;

import java.util.ArrayList;

/**
 * This class is used to store the properties of a block
 */
public class BlockCode {
    public String opcode;
    public String format;
    public int color;
    public ParseBlockTask parseBlockTask;
    public ArrayList<String> parameters;

    public BlockCode(String opcode, String format, int color, ParseBlockTask parseBlockTask, ArrayList<String> parameters) {
        this.opcode = opcode;
        this.format = format;
        this.color = color;
        this.parseBlockTask = parseBlockTask;
        this.parameters = parameters;
    }
}
