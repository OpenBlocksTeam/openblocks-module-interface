package com.openbloks.moduleinterface.projectfiles;

import com.openbloks.moduleinterface.models.layout.LayoutView;
import com.openbloks.moduleinterface.models.layout.LayoutViewXMLAttribute;

/**
 * OpenBlocksLayout is a model that is used to represent a layout in XML with the parent name of
 * {@link #parent_layout_name} with the attribute of {@link #parent_xml_attribute}
 * with the child of {@link #child}
 */
public class OpenBlocksLayout {
    public String parent_layout_name;
    public LayoutViewXMLAttribute parent_xml_attribute;
    public LayoutView child;

    public OpenBlocksLayout(String parent_layout_name, LayoutViewXMLAttribute parent_xml_attribute, LayoutView child) {
        this.parent_layout_name = parent_layout_name;
        this.parent_xml_attribute = parent_xml_attribute;
        this.child = child;
    }
}
