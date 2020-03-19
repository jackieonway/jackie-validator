package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.DateCompareConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Check start time and end time,
 *
 * @author Jackie
 * @version \$Id: DateCompare.java, v 0.1 2019-10-13 14:26 Jackie Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateCompareConstraint.class)
public @interface DateCompare {

    String message() default "Time comparison parameter check error";

    /**
     * Is it necessary
     */
    boolean must() default false;

    /**
     * Start time field, field starts with spel expression <i> # </i>
     */
    String startTime();

    /**
     * End time field, field starts with spel expression  <i> # </i>
     */
    String endTime();

    Class<?>[] groups() default {};

    /**
     * Whether it is less than or equal to the current time
     */
    boolean lessOrEqualThanNow() default false;

    Class<? extends Payload>[] payload() default {};


    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        DateCompare[] value();
    }
}
