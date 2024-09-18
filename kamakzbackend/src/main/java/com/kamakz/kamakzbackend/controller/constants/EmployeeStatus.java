package com.kamakz.kamakzbackend.controller.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Evans
 */
public enum EmployeeStatus {
    ACTIVE("active", "Active"),
    INACTIVE("inactive", "In Active"),
    CLOSED("closed", "Closed"),
    DECEASED("deceased","Deceased"),
    RETIRED("retired","Retired");

    private String key;
    private String label;

    private EmployeeStatus(String key, String label) {
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

    public static List<EmployeeStatus> asList() {
        List<EmployeeStatus> asList = new ArrayList<>(Arrays.asList(EmployeeStatus.values()));
        return asList;
    }

}

