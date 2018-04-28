package com.j.spring.ch20.service;

import com.j.spring.ch20.common.CommonLogger;
import com.j.spring.ch20.model.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticatorImpl implements Authenticator {

    @Autowired
    private CommonLogger commonLogger;

    public void authenticate(LoginCommand loginCommand) throws AuthenicationException {
        if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
            //로그인 에러시 콘솔창에 찍어주는 기능
            commonLogger.log("인증 에러 - "+loginCommand.getUserId());
            //예외를 발생시킴
            throw new AuthenicationException();
        }
    }

    public CommonLogger getCommonLogger() {
        return commonLogger;
    }


    public void setCommonLogger(CommonLogger commonLogger) {
        this.commonLogger = commonLogger;
    }
}
