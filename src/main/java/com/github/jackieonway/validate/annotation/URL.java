/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.UrlConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Jackie
 * @version $id: URL.java v 0.1 2019-10-16 10:58 Jackie Exp $$
 */
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UrlConstraint.class)
public @interface URL {

    String message() default "url checks error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
