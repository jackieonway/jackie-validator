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
     * 转化Object 对象为 StandardEvaluationContext 对象
     * @param object 待转化对象
     * @param context 转化后上下文对象
     * @param validatorContext 校验上下文
     * @author  Jackie
     * @since 1.0
     * @see StandardEvaluationContextUtil
     */
    public static void convertContext(Object object, StandardEvaluationContext context,
                                      ConstraintValidatorContext validatorContext){
        Class<?> aClass = object.getClass();
        Arrays.stream(aClass.getDeclaredFields()).forEach(m -> {
            m.setAccessible(true);
            try {
                Object o = m.get(object);
                context.setVariable(m.getName(), o);
            } catch (IllegalAccessException e) {
                ValidMessageUtils.validMessage(e.toString(),validatorContext);
            }
        });
    }
}
