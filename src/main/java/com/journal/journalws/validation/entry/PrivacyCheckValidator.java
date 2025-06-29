package com.journal.journalws.validation.entry;

import com.journal.journalws.annotation.entry.PrivacyCheck;
import com.journal.journalws.enums.entry.Privacy;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class PrivacyCheckValidator implements ConstraintValidator<PrivacyCheck, String> {

    private static final Set<String> PRIVACY = Privacy.getValueSet();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && PRIVACY.contains(value);
    }

}