package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.constants.MessageResolvable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jboss
 */
public enum Gender implements MessageResolvable {
    MALE("gender_male", "Male"), FEMALE("gender_female", "Female"), UNISEX("gender_unisex", "Unisex");
    private final String key;
    private String label;

    private Gender(String key, String label) {
        this.key = key;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getMessageKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return label;
    }

    public Gender getFEMALE() {
        return FEMALE;
    }

    public Gender getMALE() {
        return MALE;
    }

    public static List<Gender> getGenderList() {
        List<Gender> asList = new ArrayList<>(Arrays.asList(Gender.values()));
        asList.remove(UNISEX);
        return asList;
    }

    public static List<Gender> getAllGenderList() {
        List<Gender> asList = new ArrayList<>(Arrays.asList(Gender.values()));
        return asList;
    }

    public static List<MessageResolvable> asResolvableList() {
        List<MessageResolvable> resolvables = new ArrayList<>();
        resolvables.addAll(getGenderList());
        return resolvables;
    }

    public static List<MessageResolvable> asAllResolvableList() {
        List<MessageResolvable> resolvables = new ArrayList<>();
        resolvables.addAll(getAllGenderList());
        return resolvables;
    }

}

