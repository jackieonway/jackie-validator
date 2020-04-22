/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.AllEqualConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Check if all parameters are equal
 *
 * @author Jackie
 * @version $id: AllEqual.java v 0.1 2019-10-21 9:17 Jackie Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllEqualConstraint.class)
public @interface AllEqual {

    String[] value();

    String message() default "param value is not equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        AllEqual[] value();
    }
}
