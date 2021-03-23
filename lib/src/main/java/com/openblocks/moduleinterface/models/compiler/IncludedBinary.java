package com.openblocks.moduleinterface.models.compiler;

import java.io.IOException;
import java.io.InputStream;

public class IncludedBinary {
    public String name;
    public int version;
    public String path;

    public IncludedBinary(String name, int version, String path) {
        this.name = name;
        this.version = version;
        this.path = path;
    }

    public Process executeWithParams(String params) throws IOException {
        return Runtime.getRuntime().exec("" + path + " " + params);
    }
}
