package ch06.model;

public class Movie {
    private String id;
    private String title;
    private int level;
    public Movie(){}

    public Movie(String id, String title, int level) {
        this.id = id;
        this.title = title;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
