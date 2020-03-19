/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;


import com.github.jackieonway.validate.constraint.RangesConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Value range of the validation field
 *
 * @author Jackie
 * @version $id: Ranges.java v 0.1 2019-10-10 10:48 Jackie Exp $$
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RangesConstraint.class})
public @interface Ranges {

    String[] params();

    String message() default "Ranges Validate Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
