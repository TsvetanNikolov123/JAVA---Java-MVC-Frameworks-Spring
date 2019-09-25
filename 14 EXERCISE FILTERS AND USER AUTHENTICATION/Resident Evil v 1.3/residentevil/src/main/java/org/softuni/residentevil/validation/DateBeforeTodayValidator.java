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
@Constraint(validatedBy = DateBeforeTodayValidatorImpl.class)
@ReportAsSingleViolation
public @interface DateBeforeTodayValidator {

    String message() default "Invalid date! Date, should be before the “today” date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

