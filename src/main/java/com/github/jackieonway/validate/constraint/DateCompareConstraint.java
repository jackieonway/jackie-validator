
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
public class DateCompareConstraint implements ConstraintValidator<DateCompare,Object> {

	/**
	 * 开始时间
	 */
	private String startTime;

	/**
	 * 结束时间
	 */
	private String endTime;

	/**
	 * 是否必须
	 */
	private boolean must;

	/**
	 * 是否小于现在时间
	 */
	private boolean lessThanNow;

	private static final ExpressionParser PARSER = new SpelExpressionParser();
	private static final StandardEvaluationContext CONTEXT = new StandardEvaluationContext();

	@Override
	public void initialize(DateCompare constraintAnnotation) {
		this.endTime = constraintAnnotation.endTime();
		this.startTime = constraintAnnotation.startTime();
		this.must = constraintAnnotation.must();
		this.lessThanNow = constraintAnnotation.lessThanNow();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		String name = o.getClass().getSimpleName();
		CONTEXT.setVariable(name.substring(0, 1).toLowerCase() + name.substring(1), o);
		Date start = PARSER.parseExpression(startTime).getValue(CONTEXT,Date.class);
		Date end = PARSER.parseExpression(endTime).getValue(CONTEXT,Date.class);
		if (must) {
			if (Objects.isNull(start)) {
				constraintValidatorContext.disableDefaultConstraintViolation();
				constraintValidatorContext.buildConstraintViolationWithTemplate("start time is null.").addConstraintViolation();
				return false;
			}
			if (Objects.isNull(end)) {
				constraintValidatorContext.disableDefaultConstraintViolation();
				constraintValidatorContext.buildConstraintViolationWithTemplate("end time is null.").addConstraintViolation();
				return false;
			}
		}else {
			if (Objects.isNull(start) || Objects.isNull(end)) {
				return true;
			}
		}
		if (lessThanNow){
			if (start.after(new Date())) {
				constraintValidatorContext.disableDefaultConstraintViolation();
				constraintValidatorContext.buildConstraintViolationWithTemplate("start time is after than now.").addConstraintViolation();
				return false;
			}
			if (end.after(new Date())) {
				constraintValidatorContext.disableDefaultConstraintViolation();
				constraintValidatorContext.buildConstraintViolationWithTemplate("end time is after than now.").addConstraintViolation();
				return false;
			}
		}
		return start.before(end);

	}
}
