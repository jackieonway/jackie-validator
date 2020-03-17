/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * @author Jackie
 * @version $id: StandardEvaluationContextUtil.java v 0.1 2019-10-21 14:58 Jackie Exp $$
 */
public class StandardEvaluationContextUtil {

    /**
     * Convert Object to {@link  org.springframework.expression.spel.support.StandardEvaluationContext}
     *
     * @param object           Object to be converted
     * @param context          Transformed Context Object
     * @param validatorContext context
     * @author Jackie
     * @see StandardEvaluationContextUtil
     * @since 1.0
     */
    public static void convertContext(Object object, StandardEvaluationContext context,
                                      ConstraintValidatorContext validatorContext) {
        Class<?> aClass = object.getClass();
        Arrays.stream(aClass.getDeclaredFields()).forEach(m -> {
            m.setAccessible(true);
            try {
                Object o = m.get(object);
                context.setVariable(m.getName(), o);
            } catch (IllegalAccessException e) {
                ValidMessageUtils.validMessage(e.toString(), validatorContext);
            }
        });
    }
}
