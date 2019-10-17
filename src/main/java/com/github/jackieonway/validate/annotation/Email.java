/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;


import com.github.jackieonway.validate.constraint.EmailConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Jackie
 * @version $id: Email.java v 0.1 2019-10-16 11:13 Jackie Exp $$
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailConstraint.class)
public @interface Email {
    String message() default "email checks error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
