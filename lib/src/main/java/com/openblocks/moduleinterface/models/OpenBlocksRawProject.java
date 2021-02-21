package com.openblocks.moduleinterface.models;

import java.util.ArrayList;

public class OpenBlocksRawProject {

    public String ID;
    public ArrayList<OpenBlocksFile> files;

    public OpenBlocksRawProject() { }

    public OpenBlocksRawProject(String ID, ArrayList<OpenBlocksFile> files) {
        this.ID = ID;
        this.files = files;
    }
}
