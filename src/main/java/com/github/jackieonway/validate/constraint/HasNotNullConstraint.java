/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.HasNotNull;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Jackie
 * @version $id: HasNotNullConstraint.java v 0.1 2019-10-21 14:12 Jackie Exp $$
 */
public class HasNotNullConstraint implements ConstraintValidator<HasNotNull, Object> {

    private static final StandardEvaluationContext CONTEXT = new StandardEvaluationContext();
    private List<String> params;

    @Override
    public void initialize(HasNotNull constraint) {
        this.params = Arrays.asList(constraint.value());
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        StandardEvaluationContextUtil.convertContext(object, CONTEXT, context);
        for (String value : params) {
            Object o = CONTEXT.lookupVariable(value);
            if (Objects.nonNull(o)) {
                return true;
            }
        }
        return false;
    }
}
