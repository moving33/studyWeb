package com.j.spring.ch20.controller;

import com.j.spring.ch20.model.LoginCommand;
import com.j.spring.ch20.service.AuthenicationException;
import com.j.spring.ch20.service.Authenticator;
import com.j.spring.ch20.validation.LoginCommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//아래로 들어오는 요청을 처리함
@RequestMapping("ch20/login/login.do")
public class LoginController {

    private String formViewName = "login/form";
    //로그인 인증 인터페이스

    @Autowired
    private Authenticator authenticator;

    //get으로 올때 처리하는 ...
    @RequestMapping(method = RequestMethod.GET)
    public String form(){
        System.out.println("GET방식 요청 처리");
        return formViewName;
    }

    //모델속성에 해당메서드 저장 새로운 객체를 만드는 requestmapping보다 먼저 처리됨으로 초기화 값을
    //세팅을 할수 있음.. ? 근데 왜 안됨?
    @ModelAttribute
    public LoginCommand formBacking(){
        System.out.println("ModelAttribute 처리 ... ");
        LoginCommand command = new LoginCommand();
        return command;
    }


    //Post로 올때 처리하는 메서드
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@Validated LoginCommand loginCommand, BindingResult result){
        if(result.hasErrors()){
            return formViewName;
        }

        try{
            //로그인 검증
            authenticator.authenticate(loginCommand);
            return "redirect:/index.jsp";
        }catch (AuthenicationException e){
            result.reject("invalidIdOrPassword",new Object[]{loginCommand.getUserId()},null);
            return formViewName;
        }
    }

    //초기화시 예외처리를 추가시키는...
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(new LoginCommandValidator());
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public String getFormViewName() {
        return formViewName;
    }

    public void setFormViewName(String formViewName) {
        this.formViewName = formViewName;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }
}
