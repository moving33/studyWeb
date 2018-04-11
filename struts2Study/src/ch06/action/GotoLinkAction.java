package ch06.action;

public class GotoLinkAction {
    private String param;

    public String execute()throws Exception{
        return "success";
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
