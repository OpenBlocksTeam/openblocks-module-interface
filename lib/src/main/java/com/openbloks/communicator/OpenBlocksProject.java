package com.openbloks.communicator;

import java.util.ArrayList;

public class OpenBlocksProject {

    public String ID;
    public ArrayList<OpenBlocksFile> files;

    public OpenBlocksProject() { }

    public OpenBlocksProject(String ID, ArrayList<OpenBlocksFile> files) {
        this.ID = ID;
        this.files = files;
    }
}
