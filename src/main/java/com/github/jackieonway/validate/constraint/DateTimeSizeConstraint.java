/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.DateTimeSize;
import com.github.jackieonway.validate.exception.ValidatedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jackie
 * @version $id: DateTimeSizeConstraint.java v 0.1 2019-10-12 16:01 Jackie Exp $$
 */
public class DateTimeSizeConstraint implements ConstraintValidator<DateTimeSize, Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeSizeConstraint.class);

    private DateTimeSize dateTimeSize;

    @Override
    public void initialize(DateTimeSize constraint) {
        this.dateTimeSize = constraint;
    }

    @Override
    public boolean isValid(Object datetime, ConstraintValidatorContext context) {
        String start = dateTimeSize.start();
        String end = dateTimeSize.end();
        String className = DateTimeSize.class.getName();
        if (StringUtils.isBlank(start)) {
            ValidMessageUtils.validMessage(className + ".startTime can not be null", context);
        }
        if (StringUtils.isBlank(end)) {
            ValidMessageUtils.validMessage(className + ".endTime can not be null", context);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeSize.pattern());
        try {
            Date startDate = simpleDateFormat.parse(start);
            Date endDate = simpleDateFormat.parse(end);
            Date date;
            if (datetime instanceof String) {
                if (((String) datetime).trim().length() != dateTimeSize.pattern().length()) {
                    ValidMessageUtils.validMessage(
                            String.format(className + "'s param \"pattern\" maybe is \"%s\"", dateTimeSize.pattern()), context);
                    return false;
                }
                date = simpleDateFormat.parse(datetime.toString());
            }
            // When the field is java.util.Date, the pattern field is not validated and the setting is invalid
            else if (datetime instanceof Date) {
                date = (Date) datetime;
            } else {
                ValidMessageUtils.validMessage(className + " date time can not parse", context);
                return false;
            }
            if (date.before(startDate)) {
                return false;
            }
            if (date.after(endDate)) {
                return false;
            }

        } catch (ParseException e) {
            LOGGER.error("Validator Error : {}", e.getMessage(), e);
            throw new ValidatedException(e.getMessage());
        }
        return true;
    }
}
