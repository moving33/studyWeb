package ch06.action;

public class EchoAction {
    private String echo;

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public String execute()throws Exception{
        return "success";
    }
}
