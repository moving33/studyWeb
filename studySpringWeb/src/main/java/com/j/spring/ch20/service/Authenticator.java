package com.j.spring.ch20.service;

import com.j.spring.ch20.model.LoginCommand;

public interface Authenticator {
    //로그인 인증 인터페이스
    void authenticate(LoginCommand loginCommand)throws AuthenicationException;
}
