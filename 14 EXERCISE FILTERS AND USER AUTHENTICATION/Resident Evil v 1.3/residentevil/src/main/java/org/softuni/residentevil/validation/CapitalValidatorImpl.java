package org.softuni.residentevil.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CapitalValidatorImpl implements ConstraintValidator<CapitalValidator, List> {
    @Override
    public void initialize(CapitalValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        if (value.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
