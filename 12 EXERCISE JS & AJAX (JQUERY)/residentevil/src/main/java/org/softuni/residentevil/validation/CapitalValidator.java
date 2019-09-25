package org.softuni.residentevil.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Constraint(validatedBy = CapitalValidatorImpl.class)
public @interface CapitalValidator {

    String message() default "You must select at least one capital!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

