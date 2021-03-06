package com.openblocks.moduleinterface.models;

public class OpenBlocksProjectMetadata {
    String name;
    String package_name;
    String version_name;
    int version_code;

    public OpenBlocksProjectMetadata(String name, String package_name, String version_name, int version_code) {
        this.name = name;
        this.package_name = package_name;
        this.version_name = version_name;
        this.version_code = version_code;
    }

    public String getName() {
        return name;
    }

    public String getPackageName() {
        return package_name;
    }

    public String getVersionName() {
        return version_name;
    }

    public int getVersionCode() {
        return version_code;
    }
}
