package com.ea.coding.model;

public class Band {

    private String name;
    private String recordLabel;

    public Band() {
    }

    public Band(String name, String recordLabel) {
        this.name = name;
        this.recordLabel = recordLabel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }
}
