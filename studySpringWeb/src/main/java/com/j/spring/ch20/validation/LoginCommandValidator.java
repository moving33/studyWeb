package com.j.spring.ch20.validation;

import com.j.spring.ch20.model.LoginCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

//validator 를 상속받은 클래스
public class LoginCommandValidator implements org.springframework.validation.Validator {
    public boolean supports(Class<?> aClass) {
        return LoginCommand.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","required");
    }
}
