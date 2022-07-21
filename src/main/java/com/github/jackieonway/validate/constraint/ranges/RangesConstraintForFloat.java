/**
 * Jackie.
 * Copyright (c)) 2019 - 2020 All Right Reserved
 */
package com.github.jackieonway.validate.constraint.ranges;

import com.github.jackieonway.validate.constraint.AbstractRangesConstraint;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jackie
 * @version $id: RangesConstraintForFloat.java v 0.1 2020-03-19 17:20 Jackie Exp $$
 */
public class RangesConstraintForFloat extends AbstractRangesConstraint<Float> {
    @Override
    protected boolean check(Float param, List<String> params) {
        List<Float> floats = params.stream().map(Float::valueOf).collect(Collectors.toList());
        return floats.contains(param);
    }
}
