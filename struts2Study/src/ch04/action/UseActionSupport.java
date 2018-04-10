package ch04.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.Locale;

public class UseActionSupport extends ActionSupport {

    private Locale myLocale;
    private String message;

    public String execute()throws Exception{

        myLocale = getLocale();
        message = new Date()+" - "+getText("label.message");

        return SUCCESS;
    }

    public Locale getMyLocale() {
        return myLocale;
    }

    public void setMyLocale(Locale myLocale) {
        this.myLocale = myLocale;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
