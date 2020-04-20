/**
 * Jackie.
 * Copyright (c)) 2019 - 2020 All Right Reserved
 */
package com.github.jackieonway.validate.constraint.ranges;

import com.github.jackieonway.validate.constraint.AbstractRangesConstraint;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jackie
 * @version $id: RangesConstraintForBigDecimal.java v 0.1 2020-03-19 17:20 Jackie Exp $$
 */
public class RangesConstraintForBigDecimal extends AbstractRangesConstraint<BigDecimal> {
    @Override
    protected boolean check(BigDecimal param, List<String> params) {
        List<BigDecimal> bigDecimals = params.stream().map(m -> new BigDecimal(m)).collect(Collectors.toList());
        return bigDecimals.contains(param);
    }
}
