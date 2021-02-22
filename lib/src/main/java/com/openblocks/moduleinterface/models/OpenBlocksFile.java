package com.openblocks.moduleinterface.models;

/**
 * This class is basically used to store a file's data with the name on it, nothing special.
 */
public class OpenBlocksFile {
    public byte[] data;
    public String name;

    public OpenBlocksFile() { }

    public OpenBlocksFile(byte[] data, String name) {
        this.data = data;
        this.name = name;
    }
}
