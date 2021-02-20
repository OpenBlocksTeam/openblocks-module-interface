package com.openbloks.communicator.projectfiles;

import com.openbloks.communicator.models.code.BlockCode;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenBlocksCode {
    public ArrayList<HashMap<String, String>> code_templates;
    public ArrayList<BlockCode> blocks;

    public OpenBlocksCode(ArrayList<HashMap<String, String>> code_templates) {
        this.code_templates = code_templates;
    }

    public OpenBlocksCode(ArrayList<HashMap<String, String>> code_templates, ArrayList<BlockCode> blocks) {
        this.code_templates = code_templates;
        this.blocks = blocks;
    }
}
