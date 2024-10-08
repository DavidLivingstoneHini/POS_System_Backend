package com.kamakz.kamakzbackend.controller.constants;

public enum SalaryType {
    WAGES("wages", "Wages"),
    SALARY("salary", "Salary");

    private String key;
    private String label;

    private SalaryType(String key, String label) {
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

