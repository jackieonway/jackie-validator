/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.Email;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author Jackie
 * @version $id: EmailConstraint.java v 0.1 2019-10-16 11:14 Jackie Exp $$
 */
public class EmailConstraint implements ConstraintValidator<Email, String> {

   private static final String REGEX = "^[a-zA-Z0-9\\-\\_\\#\\$\\%\\^\\&\\*\\(\\)\\?]+\\@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";
   @Override
   public void initialize(Email constraint) {
   }

   @Override
   public boolean isValid(String email, ConstraintValidatorContext context) {
      if (StringUtils.isBlank(email)){
         return true;
      }
      Pattern pattern = Pattern.compile(REGEX);
      return pattern.matcher(email).matches();
   }
}
