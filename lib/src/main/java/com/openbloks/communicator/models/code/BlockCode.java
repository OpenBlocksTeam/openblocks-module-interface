package com.openbloks.communicator.models.code;

import java.util.ArrayList;

public class BlockCode {
    public String opcode;
    public ArrayList<String> parameters;

    public BlockCode(String opcode, ArrayList<String> parameters) {
        this.opcode = opcode;
        this.parameters = parameters;
    }
}
