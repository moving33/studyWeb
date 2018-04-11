package ch05.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserRegAction extends ActionSupport {

    private String userId;
    private String userPass;
    private String userName;
    private String message;

    public String execute() throws Exception{
        message = userId + "님 정보가 성공적으로 등록되었습니다.";
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
