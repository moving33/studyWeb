package ch06.action;

import java.util.ArrayList;
import java.util.List;

public class AppendListAction {
    private List<String> listPainter;
    private List<String> listMusician;

    public String execute()throws Exception{
        listPainter  = new ArrayList<>();
        listPainter.add("Claude Monet");
        listPainter.add("Vincent van Gogh");
        listPainter.add("Paul Gauguin");
        listPainter.add("Picaso");

        listMusician  = new ArrayList<>();
        listMusician.add("Mozart");
        listMusician.add("Rudevih van Betoven");
        listMusician.add("Franz Peter Schubert");
        listMusician.add("Trevihi vaan Toornet");

        return "success";
    }

    public List<String> getListPainter() {
        return listPainter;
    }

    public void setListPainter(List<String> listPainter) {
        this.listPainter = listPainter;
    }

    public List<String> getListMusician() {
        return listMusician;
    }

    public void setListMusician(List<String> listMusician) {
        this.listMusician = listMusician;
    }
}
