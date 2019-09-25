package org.softuni.residentevil.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateBeforeTodayValidatorImpl implements ConstraintValidator<DateBeforeTodayValidator, LocalDate> {

    @Override
    public void initialize(DateBeforeTodayValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        LocalDate today = LocalDate.now();
        if (date == null){
            return false;
        }
        return date.isBefore(today);
    }
}
