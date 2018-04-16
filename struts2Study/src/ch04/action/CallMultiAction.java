package ch04.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class CallMultiAction extends ActionSupport implements Preparable {

    public String execute() throws Exception{
        return SUCCESS;
    }

    public String actionOne() throws Exception{
        System.out.println(">>>actionOne.action");
        return SUCCESS;
    }

    public String actionTwo()throws Exception{
        System.out.println(">>>actionTwo.action");
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {

    }
}
