/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.AllEqualConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Check if all parameters are equal
 *
 * @author Jackie
 * @version $id: AllEqual.java v 0.1 2019-10-21 9:17 Jackie Exp $$
 */
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AllEqualConstraint.class)
public @interface AllEqual {

    String[] value();

    String message() default "param value is not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        AllEqual[] value();
    }
}
