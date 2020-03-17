/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.AllEqual;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Jackie
 * @version $id: AllEqualConstraint.java v 0.1 2019-10-21 9:18 Jackie Exp $$
 */
public class AllEqualConstraint implements ConstraintValidator<AllEqual, Object> {

    private static final StandardEvaluationContext CONTEXT = new StandardEvaluationContext();
    private List<String> values;

    @Override
    public void initialize(AllEqual constraint) {
        this.values = Arrays.asList(constraint.value());
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        StandardEvaluationContextUtil.convertContext(object, CONTEXT, context);
        Object temp = null;
        for (String value : values) {
            Object o = CONTEXT.lookupVariable(value);
            if (Objects.nonNull(temp)) {
                if (Objects.isNull(o)) {
                    continue;
                }
                if (!Objects.deepEquals(temp, o)) {
                    return false;
                }
            }
            temp = o;
        }
        return true;
    }

}
