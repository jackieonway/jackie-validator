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
 * @version $id: RangesConstraintForInteger.java v 0.1 2020-03-19 15:40 Jackie Exp $$
 */
public class RangesConstraintForInteger extends AbstractRangesConstraint<Integer> {
    @Override
    protected boolean check(Integer param, List<String> params) {
        List<Integer> integers = params.stream().map(m -> Integer.valueOf(m)).collect(Collectors.toList());
        return integers.contains(param);
    }
}
