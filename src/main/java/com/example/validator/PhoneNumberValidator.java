package com.example.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public boolean isValid(String phoneNumber,
                           ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }
        if (!phoneNumber.matches("[+]3897[0156][0-9]{6}")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("invalid format").addConstraintViolation();
            return false;
        }
        return true;
    }
}
