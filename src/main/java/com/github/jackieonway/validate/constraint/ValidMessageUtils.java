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

    private ValidMessageUtils(){}

    /**
     * 返回检验结果信息
     *
     * @param message                    错误信息
     * @param constraintValidatorContext 校验容器
     */
    static void validMessage(String message, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }


    /**
     * 返回检验结果信息
     *
     * @param message                    错误信息
     * @param constraintValidatorContext 校验容器
     * @return 返回false直接结束校验
     */
    static boolean returnMessage(String message, ConstraintValidatorContext constraintValidatorContext) {
        validMessage(message, constraintValidatorContext);
        return false;
    }
}
