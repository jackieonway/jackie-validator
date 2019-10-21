/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.HasNotNullConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Jackie
 * @version $id: HasNotNull.java v 0.1 2019-10-21 14:09 Jackie Exp $$
 */
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = HasNotNullConstraint.class)
public @interface HasNotNull {

    String[] value();

    String message() default "all params are null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        HasNotNull[] value();
    }
}
