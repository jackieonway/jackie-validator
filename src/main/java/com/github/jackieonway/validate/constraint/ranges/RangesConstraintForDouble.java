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
 * @version $id: RangesConstraintForDouble.java v 0.1 2020-03-19 17:20 Jackie Exp $$
 */
public class RangesConstraintForDouble extends AbstractRangesConstraint<Double> {
    @Override
    protected boolean check(Double param, List<String> params) {
        List<Double> doubles = params.stream().map(m -> Double.valueOf(m)).collect(Collectors.toList());
        return doubles.contains(param);
    }
}
