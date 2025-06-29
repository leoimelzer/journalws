package com.journal.journalws.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestUtils {

    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public static LocalDateTime getLocalDateTimeByParameter(String parameter) {
        try {
            return LocalDateTime.parse(parameter, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> getStringListByParameter(String parameter) {
        if (parameter == null || parameter.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.asList(parameter.split("\\s*,\\s*"));
    }


}
