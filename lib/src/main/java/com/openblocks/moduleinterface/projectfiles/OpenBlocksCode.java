package com.openblocks.moduleinterface.projectfiles;

import com.openblocks.moduleinterface.models.code.BlockCode;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: 3/18/21 Should be possible to make multiple collection of blocks / activity
public class OpenBlocksCode {
    public ArrayList<HashMap<String, String>> code_templates;
    public ArrayList<BlockCode> blocks = new ArrayList<>();

    public OpenBlocksCode(ArrayList<HashMap<String, String>> code_templates) {
        this.code_templates = code_templates;
    }

    public OpenBlocksCode(ArrayList<HashMap<String, String>> code_templates, ArrayList<BlockCode> blocks) {
        this.code_templates = code_templates;
        this.blocks = blocks;
    }
}
