/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.CheckList;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;


/**
 * @author Jackie
 * @version $id: CheckListConstraint.java v 0.1 2019-10-10 10:50 Jackie Exp $$
 */
public class CheckListConstraint implements ConstraintValidator<CheckList, String> {

   private CheckList checkList;

   @Override
   public void initialize(CheckList checkList) {
      this.checkList = checkList;
   }

   @Override
   public boolean isValid(String param, ConstraintValidatorContext context) {
      List<String> params = Arrays.asList(checkList.params());
      if (CollectionUtils.isEmpty(params)){
         return ValidMessageUtils.returnMessage("params can not be null", context);
      }
      return params.contains(param);
   }
}
