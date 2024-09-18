package com.kamakz.kamakzbackend.model.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jboss
 */
public enum InventoryTraceability {
    NONE("none", "None"),
    SINGLE("single", "Single"),
    MULTIPLES("multiples", "Multiples");

    private String key;
    private String label;

    private InventoryTraceability(String key, String label) {
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

    public static List<InventoryTraceability> asList() {
        List<InventoryTraceability> asList = new ArrayList<>(Arrays.asList(InventoryTraceability.values()));
        return asList;
    }
}