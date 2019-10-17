package com.github.jackieonway.validate.annotation;

import com.github.jackieonway.validate.constraint.DateCompareConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Jackie
 * @version \$Id: DateCompare.java, v 0.1 2019-10-13 14:26 Jackie Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateCompareConstraint.class)
public @interface DateCompare {

    String message() default "时间比较参数校验错误";

    /**
     * 是否必须
     */
    boolean must() default false;

    String startTime();

    String endTime();

    Class<?>[] groups() default {};

    /**
     * 是否大于现在时间
     */
    boolean lessThanNow() default false;

    Class<? extends Payload>[] payload() default {};


    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        DateCompare[] value();
    }
}
