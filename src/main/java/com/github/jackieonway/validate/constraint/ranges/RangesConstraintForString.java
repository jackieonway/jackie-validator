/**
 * Jackie.
 * Copyright (c)) 2019 - 2020 All Right Reserved
 */
package com.github.jackieonway.validate.constraint.ranges;

import com.github.jackieonway.validate.constraint.AbstractRangesConstraint;

import java.util.List;

/**
 * @author Jackie
 * @version $id: RangesConstraintForString.java v 0.1 2020-03-19 15:52 Jackie Exp $$
 */
public class RangesConstraintForString extends AbstractRangesConstraint<String> {
    @Override
    protected boolean check(String param, List<String> params) {
        return params.contains(param);
    }
}
