package com.openbloks.moduleinterface.projectfiles;

import com.openbloks.moduleinterface.models.layout.LayoutView;

public class OpenBlocksLayout {
    public String parent_layout_name;
    public LayoutView child;

    public OpenBlocksLayout(String parent_layout_name, LayoutView child) {
        this.parent_layout_name = parent_layout_name;
        this.child = child;
    }
}
