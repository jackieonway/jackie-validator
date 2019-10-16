/**
 * Jackie.
 * Copyright (c)) 2019 - 2019 All Right Reserved
 */
package com.github.jackieonway.validate.constraint;

import com.github.jackieonway.validate.annotation.URL;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author Jackie
 * @version $id: UrlConstraint.java v 0.1 2019-10-16 10:59 Jackie Exp $$
 */
public class UrlConstraint implements ConstraintValidator<URL, String> {

   private static final String REGX = "^" +
           //pattern protocols
           "(([hH][tT]{2}[pP][sS]{0,1}|[fF][tT][pP])://)?" +
           //pattern ipv4
           "(" +
           "(([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(.([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})" +
           //pattern ipv6
           "|(([0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}|[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){0,6}:{2})" +
           "|:(:[0-9a-fA-F]{1,4}){1,6}|([0-9a-fA-F]{1,4}:){1,6}(:[0-9a-fA-F]{1,4}))" +
           //pattern url
           "|([a-zA-Z0-9-~]+(.[a-zA-Z0-9-~]+)+)" +
           ")" +
           //pattern port
           "(:([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d{1}|6553[0-5]))?" +
           //pattern uri
           "(/?|(/[a-zA-Z-~0-9\\-_.#]+)*)(\\?[a-zA-Z0-9-~]+=[\\sa-zA-Z0-9-~&\\{\"\\}:\\,%]+(&[a-zA-Z0-9-~]+=[\\sa-zA-Z0-9-~&\\\\{\"\\}:\\,%]+)*)?" +
           "$";

   @Override
   public void initialize(URL url) {
   }

   @Override
   public boolean isValid(String url, ConstraintValidatorContext context) {
      if (StringUtils.isBlank(url.trim())){
         return true;
      }
      Pattern pattern = Pattern.compile(REGX);
      return pattern.matcher(url).matches();
   }
}
