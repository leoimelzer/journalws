package com.journal.journalws.enums.entry;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Privacy {
    PUBLIC,
    FRIENDS_ONLY,
    PRIVATE,
    CUSTOM;

    public static Set<String> getValueSet() {
        return Arrays.stream(Privacy.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }
}
