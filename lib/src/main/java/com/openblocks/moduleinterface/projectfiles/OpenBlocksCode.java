package com.openblocks.moduleinterface.projectfiles;

import com.openblocks.moduleinterface.models.code.BlockCode;
import com.openblocks.moduleinterface.models.code.ParseBlockTask;

import java.util.ArrayList;
import java.util.HashMap;

// TODO: 3/18/21 Should be possible to make multiple collection of blocks / activity
// TODO: 3/18/21 Customizable code template
public class OpenBlocksCode {
    public HashMap<String, ParseBlockTask> code_templates;
    public ArrayList<BlockCode> blocks = new ArrayList<>();

    public OpenBlocksCode(HashMap<String, ParseBlockTask> code_templates) {
        this.code_templates = code_templates;
    }

    public OpenBlocksCode(HashMap<String, ParseBlockTask> code_templates, ArrayList<BlockCode> blocks) {
        this.code_templates = code_templates;
        this.blocks = blocks;
    }
}
