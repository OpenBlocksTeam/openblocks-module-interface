package com.openbloks.moduleinterface.models.config;

import java.util.HashMap;
import java.util.Objects;

/**
 * OpenBlocksConfig is a list of configuration that can be added, removed, and edited
 */
public class OpenBlocksConfig {
    public enum Type {
        SWITCH,
        INPUT_TEXT,
        INPUT_NUMBER,
        OPEN_FILE,
        DROPDOWN,
        MULTIPLE_CHOICE,
    }

    HashMap<String, OpenBlocksConfigItem> config = new HashMap<>();

    public OpenBlocksConfig() { }

    public void addItem(String TAG, OpenBlocksConfigItem item) {
        config.put(TAG, item);
    }

    public void removeItem(String TAG) {
        config.remove(TAG);
    }

    public void clearItems() {
        config.clear();
    }

    public String[] getTAGs() {
        return config.keySet().toArray(new String[0]);
    }

    public Object getConfig(String TAG) {
        if (!config.containsKey(TAG)) return null;

        return Objects.requireNonNull(config.get(TAG)).value;
    }
}
