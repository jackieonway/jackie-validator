/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;



import com.github.jackieonway.validate.constraint.RangesConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Jackie
 * @version $id: Ranges.java v 0.1 2019-10-10 10:48 Jackie Exp $$
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {RangesConstraint.class})
public @interface Ranges {

    String[] params();

    String message() default "Ranges Validate Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
