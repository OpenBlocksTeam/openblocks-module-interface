package com.openblocks.moduleinterface.models.config;

/**
 * OpenBlocksConfigItem is an item of a list of configurations (on {@link OpenBlocksConfig})
 *
 * {@link #text} is the informative text that will be displayed on the left of the edit specified
 * by {@link #config_type}
 *
 * {@link #value} is the value, when creating, you can use this as the default value
 */
public class OpenBlocksConfigItem {
    public String text;
    public Object value;
    public Object extra;

    public OpenBlocksConfig.Type config_type;

    /**
     * This constructor constructs this class to an object with the provided parameters
     *
     * @param text The informative text that will be displayed alongside the action / button / edit
     * @param value The default value
     * @param extra The extra, this can only be used to store ArrayList of objects that will be displayed on DROPDOWN, and MULTIPLE_CHOICE, otherwise, just put null
     * @param config_type The configuration type, value's type should match with the config_type
     */
    public OpenBlocksConfigItem(String text, Object value, Object extra, OpenBlocksConfig.Type config_type) {
        this.text = text;
        this.value = value;
        this.extra = extra;
        this.config_type = config_type;
    }
}
