package com.openbloks.communicator.models;

public class OpenBlocksFile {
    public byte[] data;
    public String name;

    public OpenBlocksFile() { }

    public OpenBlocksFile(byte[] data, String name) {
        this.data = data;
        this.name = name;
    }
}
