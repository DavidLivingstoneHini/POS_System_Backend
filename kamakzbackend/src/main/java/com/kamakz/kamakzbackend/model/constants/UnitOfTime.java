package com.kamakz.kamakzbackend.model.constants;

public enum UnitOfTime {

    NONE("none", "None"),
    MINUTE("minute", "Minute"),
    HOUR("hour", "Hour"),
    DAY("day", "Day"),
    MONTH("month", "Month");

    private String key;
    private String label;

    private UnitOfTime(String key, String label) {
        this.key = key;
        this.label = label;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}

