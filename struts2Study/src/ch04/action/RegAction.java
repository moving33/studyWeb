package ch04.action;

import ch04.model.MyUserDAO;
import ch04.model.MyUserVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RegAction extends ActionSupport implements ModelDriven<MyUserVO>,Preparable {
    private MyUserVO myUserVO = null;
    private MyUserDAO userDAO = null;

    @Override
    public MyUserVO getModel() {
        return myUserVO;
    }

    @Override
    public void prepare() throws Exception {
        myUserVO = new MyUserVO();
        userDAO = MyUserDAO.getInstance();
    }

    public String execute()throws Exception{
        userDAO.insertMember(myUserVO);
        return SUCCESS;
    }

}
