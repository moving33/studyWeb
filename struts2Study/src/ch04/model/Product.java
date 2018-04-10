package ch04.model;

public class Product {

    private String name;
    private String modelNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set Method ... : name");
        this.name = name;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        System.out.println("set method ... : ModelNo");
        this.modelNo = modelNo;
    }
}
