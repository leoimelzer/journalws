package com.journal.journalws.validator;

import com.journal.journalws.enums.EntryPrivacy;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class PrivacyCheckValidator implements ConstraintValidator<PrivacyCheck, String> {

    private static final Set<String> PRIVACY = EntryPrivacy.getValueSet();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && PRIVACY.contains(value);
    }

}