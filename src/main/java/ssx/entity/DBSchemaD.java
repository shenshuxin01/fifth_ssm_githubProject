package ssx.entity;

import java.io.Serializable;

public class DBSchemaD implements Serializable {
    private String name;
    private String value;

    public DBSchemaD() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DBSchemaD(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
