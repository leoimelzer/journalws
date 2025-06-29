package com.journal.journalws.annotation.entry;

import com.journal.journalws.validation.entry.PrivacyCheckValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Documented
@Constraint(validatedBy = PrivacyCheckValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivacyCheck {
    String message() default "Privacy value is invalid, it must be one of the following: [PUBLIC, FRIENDS_ONLY, PRIVATE, CUSTOM].";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
