package ch06.action;

public class CheckCourseAction {
    private boolean struts2 = true;
    private boolean spring;
    private boolean ibatis;
    private boolean android;

    public String execute()throws Exception{
        return "success";
    }

    public boolean isStruts2() {
        return struts2;
    }

    public void setStruts2(boolean struts2) {
        this.struts2 = struts2;
    }

    public boolean isSpring() {
        return spring;
    }

    public void setSpring(boolean spring) {
        this.spring = spring;
    }

    public boolean isIbatis() {
        return ibatis;
    }

    public void setIbatis(boolean ibatis) {
        this.ibatis = ibatis;
    }

    public boolean isAndroid() {
        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }
}
