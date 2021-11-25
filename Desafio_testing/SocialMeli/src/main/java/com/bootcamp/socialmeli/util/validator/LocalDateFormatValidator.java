package com.bootcamp.socialmeli.util.validator;

import com.bootcamp.socialmeli.util.constraint.LocalDateFormatConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class LocalDateFormatValidator implements
        ConstraintValidator<LocalDateFormatConstraint, LocalDate> {

    private final String format = "[0-9]{2}-[0-9]{2}-[0-9]{4}";

    @Override
    public void initialize(LocalDateFormatConstraint contactNumber) {
    }

    @Override
    public boolean isValid(LocalDate dateField,
                           ConstraintValidatorContext cxt) {
        return true;
    }

}
