package com.openblocks.moduleinterface.projectfiles;

import com.openblocks.moduleinterface.models.layout.LayoutViewXMLAttribute;

import java.util.ArrayList;

/**
 * OpenBlocksLayout is a model that is used to represent a layout in XML
 */
public class OpenBlocksLayout {
    public ArrayList<OpenBlocksLayout> childs = new ArrayList<>();
    public String view_name;
    public ArrayList<LayoutViewXMLAttribute> xml_attributes;

    public OpenBlocksLayout(ArrayList<OpenBlocksLayout> childes, String view_name, ArrayList<LayoutViewXMLAttribute> xml_attributes) {
        this.childs = childes;
        this.view_name = view_name;
        this.xml_attributes = xml_attributes;
    }

    public OpenBlocksLayout(String view_name, ArrayList<LayoutViewXMLAttribute> xml_attributes) {
        this.view_name = view_name;
        this.xml_attributes = xml_attributes;
    }
}
