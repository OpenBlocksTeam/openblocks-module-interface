package com.openbloks.moduleinterface.models.layout;

public class LayoutViewXMLAttribute {
    public String prefix;
    public String attribute_name;
    public Object value;

    public LayoutViewXMLAttribute(String prefix, String attribute_name, Object value) {
        this.prefix = prefix;
        this.attribute_name = attribute_name;
        this.value = value;
    }
}
