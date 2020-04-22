package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.DateCompare;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;
import java.util.Objects;

/**
 * @author Jackie
 * @version \$Id: DateCompareConstraint.java, v 0.1 2019-10-13 14:29 Jackie Exp $$
 */
public class DateCompareConstraint implements ConstraintValidator<DateCompare, Object> {

    private static final ExpressionParser PARSER = new SpelExpressionParser();
    private static final StandardEvaluationContext CONTEXT = new StandardEvaluationContext();
    /**
     * Starting time
     */
    private String startTime;
    /**
     * End Time
     */
    private String endTime;
    /**
     * Is it necessary
     */
    private boolean must;
    /**
     * Whether it is less than or equal to the current time
     */
    private boolean lessOrEqualThanNow;

    @Override
    public void initialize(DateCompare constraintAnnotation) {
        this.endTime = constraintAnnotation.endTime();
        this.startTime = constraintAnnotation.startTime();
        this.must = constraintAnnotation.must();
        this.lessOrEqualThanNow = constraintAnnotation.lessOrEqualThanNow();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String name = o.getClass().getSimpleName();
        CONTEXT.setVariable(name.substring(0, 1).toLowerCase() + name.substring(1), o);
        Date start = PARSER.parseExpression(startTime).getValue(CONTEXT, Date.class);
        Date end = PARSER.parseExpression(endTime).getValue(CONTEXT, Date.class);
        boolean startIsNull = Objects.isNull(start);
        boolean endIsNull = Objects.isNull(end);
        boolean falg = !must && (startIsNull || endIsNull);
        if (falg) {
            return true;
        }
        String className = o.getClass().getSimpleName();
        if (startIsNull) {
            return ValidMessageUtils.returnMessage(className +".startTime is null.", constraintValidatorContext);
        }
        if (endIsNull) {
            return ValidMessageUtils.returnMessage( className +".endTime is null.", constraintValidatorContext);
        }
        if (lessOrEqualThanNow) {
            if (start.after(new Date())) {
                return ValidMessageUtils.returnMessage(className +".startTime is after than now.", constraintValidatorContext);
            }
            if (end.after(new Date())) {
                return ValidMessageUtils.returnMessage(className +".endTime is after than now.", constraintValidatorContext);
            }
        }
        if (Objects.deepEquals(start, end)) {
            return true;
        }
        return start.before(end);
    }
}
