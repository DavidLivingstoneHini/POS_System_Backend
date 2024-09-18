package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.constants.MessageResolvable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jboss
 */
public enum MaritalStatus implements MessageResolvable {

    SINGLE("Single", "marital_status_single"),
    MARRIED("Married", "marital_status_married"),
    DIVORCED("Divorced", "marital_status_divorced"),
    WIDOWED("Widowed", "marital_status_widowed"),
    SEPERATED("Separated", "marital_status_separated"),
    COHABITATION("Cohabitation", "marital_status_cohabitation");

    private String label = this.name();
    private final String messageKey;

    private MaritalStatus(String name, String messageKey) {
        this.label = name;
        this.messageKey = messageKey;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    public MaritalStatus getDIVORCED() {
        return DIVORCED;
    }

    public MaritalStatus getMARRIED() {
        return MARRIED;
    }

    public MaritalStatus getSINGLE() {
        return SINGLE;
    }

    public MaritalStatus getWIDOWED() {
        return WIDOWED;
    }

    @Override
    public String getMessageKey() {
        return this.messageKey;
    }

    public static List<MaritalStatus> asList() {
        List<MaritalStatus> asList = new ArrayList<>(Arrays.asList(MaritalStatus.values()));
        return asList;
    }

    public static List<MessageResolvable> asAllResolvableList() {
        List<MessageResolvable> resolvables = new ArrayList<>();
        resolvables.addAll(asList());
        return resolvables;
    }

}

