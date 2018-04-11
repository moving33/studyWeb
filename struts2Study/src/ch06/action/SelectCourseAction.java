package ch06.action;

import ch06.model.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCourseAction {
    //Ex one
    private List<String> listCourseExOne;
    private List<String> listCheckExOne;

    //Ex two
    private Map<String,String> mapCourseExTwo;
    private String checkExTwo;

    //Ex three
    private List<Course> lisCourseExThree;
    private String checkExThree;

    public String execute()throws Exception{
        //Ex one
        listCourseExOne = new ArrayList<String>();
        listCourseExOne.add("Struts2");
        listCourseExOne.add("Spring");
        listCourseExOne.add("iBatis");
        listCourseExOne.add("Android");

        //Ex two
        mapCourseExTwo = new HashMap<>();
        mapCourseExTwo.put("C1","Struts2");
        mapCourseExTwo.put("C2","Spring");
        mapCourseExTwo.put("C3","iBatis");
        mapCourseExTwo.put("C4","Android");

        //Ex three
        lisCourseExThree = new ArrayList<Course>();
        lisCourseExThree.add(new Course("C1","Struts2"));
        lisCourseExThree.add(new Course("C2","Spring"));
        lisCourseExThree.add(new Course("C3","iBatis"));
        lisCourseExThree.add(new Course("C4","Android"));

        return "success";
    }

    public List<String> getListCourseExOne() {
        return listCourseExOne;
    }

    public void setListCourseExOne(List<String> listCourseExOne) {
        this.listCourseExOne = listCourseExOne;
    }

    public List<String> getListCheckExOne() {
        return listCheckExOne;
    }

    public void setListCheckExOne(List<String> listCheckExOne) {
        this.listCheckExOne = listCheckExOne;
    }

    public Map<String, String> getMapCourseExTwo() {
        return mapCourseExTwo;
    }

    public void setMapCourseExTwo(Map<String, String> mapCourseExTwo) {
        this.mapCourseExTwo = mapCourseExTwo;
    }

    public String getCheckExTwo() {
        return checkExTwo;
    }

    public void setCheckExTwo(String checkExTwo) {
        this.checkExTwo = checkExTwo;
    }

    public List<Course> getLisCourseExThree() {
        return lisCourseExThree;
    }

    public void setLisCourseExThree(List<Course> lisCourseExThree) {
        this.lisCourseExThree = lisCourseExThree;
    }

    public String getCheckExThree() {
        return checkExThree;
    }

    public void setCheckExThree(String checkExThree) {
        this.checkExThree = checkExThree;
    }
}
