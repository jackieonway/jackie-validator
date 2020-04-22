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
class ValidMessageUtils {

    private ValidMessageUtils() {
    }

    /**
     * Return check result information
     *
     * @param message                    Error message
     * @param constraintValidatorContext Validator context
     */
    static void validMessage(String message, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }


    /**
     * Return check result information
     *
     * @param message                    Error message
     * @param constraintValidatorContext Validator context
     * @return Return false to end the verification directly
     */
    static boolean returnMessage(String message, ConstraintValidatorContext constraintValidatorContext) {
        validMessage(message, constraintValidatorContext);
        return false;
    }
}
