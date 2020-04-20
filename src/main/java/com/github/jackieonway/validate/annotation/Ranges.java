/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import com.github.jackieonway.validate.constraint.ranges.*;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;


/**
 * Value range of the validation field
 *
 * @author Jackie
 * @version $id: Ranges.java v 0.1 2019-10-10 10:48 Jackie Exp $$
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RangesConstraintForInteger.class, RangesConstraintForString.class,
        RangesConstraintForBigDecimal.class, RangesConstraintForDouble.class, RangesConstraintForFloat.class})
public @interface Ranges {

    String[] params();

    String message() default "Ranges Validate Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        Ranges[] value();
    }
}
