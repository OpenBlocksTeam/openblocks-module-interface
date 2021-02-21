package com.openbloks.moduleinterface.models.config;

public class OpenBlocksConfigItem {
    public String text;
    public Object value;

    public OpenBlocksConfig.Type config_type;

    public OpenBlocksConfigItem(String text, Object value, OpenBlocksConfig.Type config_type) {
        this.text = text;
        this.value = value;
        this.config_type = config_type;
    }
}
