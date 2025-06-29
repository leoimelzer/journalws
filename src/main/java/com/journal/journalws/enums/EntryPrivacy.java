package com.journal.journalws.enums;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum EntryPrivacy {
    PUBLIC("P"),
    FRIENDS_ONLY("F"),
    PRIVATE("X"),
    CUSTOM("C");

    final String value;

    EntryPrivacy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static EntryPrivacy getInstanceByValue(String value) {
        return switch (value) {
            case "P" -> PUBLIC;
            case "X" -> PRIVATE;
            case "F" -> FRIENDS_ONLY;
            case "C" -> CUSTOM;
            default -> null;
        };
    }

    public static Set<String> getValueSet() {
        return Arrays.stream(EntryPrivacy.values())
                .map(EntryPrivacy::getValue)
                .collect(Collectors.toSet());
    }

}
