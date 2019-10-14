/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import javax.validation.ConstraintValidatorContext;

/**
 * @author Jackie
 * @version $id: ValidMessageUtils.java v 0.1 2019-10-12 16:06 Jackie Exp $$
 */
public class ValidMessageUtils {

    private ValidMessageUtils(){}

    public static void validMessage(String message, ConstraintValidatorContext cvc) {
        cvc.disableDefaultConstraintViolation();
        cvc.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}
