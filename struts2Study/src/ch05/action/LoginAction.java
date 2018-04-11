package ch05.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

    private String userId;
    private String userPass;
    private String userName;
    private String message;

    @Override
    public String execute() throws Exception {
        if(message == null) message ="";
        else message = message + "<br><br>";
        message += userId + "로 로그인 하셨습니다.";
        return SUCCESS;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
