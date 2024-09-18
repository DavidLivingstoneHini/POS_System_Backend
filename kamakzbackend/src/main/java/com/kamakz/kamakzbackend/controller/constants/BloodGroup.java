package com.kamakz.kamakzbackend.controller.constants;

import com.kamakz.kamakzbackend.model.constants.MessageResolvable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jboss
 */
public enum BloodGroup implements MessageResolvable {
    A_POSITIVE("A Positive", "a_positive"),
    A_NEGATIVE("A Negative", "a_negative"),
    B_POSITIVE("B Positive", "b_positive"),
    B_NEGATIVE("B Negative", "n_negative"),
    AB_POSITIVE("AB Positive", "ab_positive"),
    AB_NEGATIVE("AB Negative", "ab_negative"),
    O_POSITIVE("O Positive", "o_positive"),
    O_NEGATIVE("O Negative", "o_negative"),
    UNKNOWN("UNKNOWN", "unknown");

    private String label;
    private final String messageKey;

    private BloodGroup(String label, String messageKey) {
        this.label = label;
        this.messageKey = messageKey;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static List<BloodGroup> asList() {
        return Arrays.asList(BloodGroup.values());
    }

    public static List<MessageResolvable> asResolvableList() {
        List<MessageResolvable> resolvables = new ArrayList<>();
        resolvables.addAll(asList());
        return resolvables;
    }
}

