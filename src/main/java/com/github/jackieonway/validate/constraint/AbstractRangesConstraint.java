/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.Ranges;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


/**
 * @author Jackie
 * @version $id: AbstractRangesConstraint.java v 0.1 2019-10-10 10:50 Jackie Exp $$
 */
public abstract class AbstractRangesConstraint<T> implements ConstraintValidator<Ranges, T> {

    private Ranges ranges;

    @Override
    public void initialize(Ranges ranges) {
        this.ranges = ranges;
    }

    @Override
    public boolean isValid(T param, ConstraintValidatorContext context) {
        List<String> params = Arrays.asList(ranges.params());
        if (CollectionUtils.isEmpty(params)) {
            return ValidMessageUtils.returnMessage(Ranges.class.getName() + "'s params can not be null", context);
        }
        return check(param,params);
    }

    protected abstract boolean check(T param,List<String> params);
}
