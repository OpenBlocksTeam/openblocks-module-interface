package com.openbloks.moduleinterface.models.layout;

import java.util.ArrayList;

public class LayoutView {
    public ArrayList<LayoutView> childes;
    public String view_name;
    public ArrayList<LayoutViewXMLAttribute> xml_attributes;

    public LayoutView(ArrayList<LayoutView> childes, String view_name, ArrayList<LayoutViewXMLAttribute> xml_attributes) {
        this.childes = childes;
        this.view_name = view_name;
        this.xml_attributes = xml_attributes;
    }

    public LayoutView(String view_name, ArrayList<LayoutViewXMLAttribute> xml_attributes) {
        this.view_name = view_name;
        this.xml_attributes = xml_attributes;
    }
}
