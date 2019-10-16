/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.github.jackieonway.validate.constraint.CheckListConstraint;

/**
 * @author Jackie
 * @version $id: CheckList.java v 0.1 2019-10-10 10:48 Jackie Exp $$
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CheckListConstraint.class})
public @interface CheckList {

   String[] params();

    String message() default "Check List Validate Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
