package com.openblocks.moduleinterface.models.code;

import java.util.ArrayList;

/**
 * BlockCodeNest is a nest of {@link BlockCode}, which can be an: If statement, While loop, For loop, function, class, etc
 */
public class BlockCodeNest extends BlockCode {
    ArrayList<BlockCode> blocks;

    public BlockCodeNest(String opcode, ArrayList<String> parameters, ArrayList<BlockCode> blocks) {
        super(opcode, parameters);
        this.blocks = blocks;
    }
}
