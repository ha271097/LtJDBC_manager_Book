package model;

public class Loaisach {
    private int id;
    private String name;

    public Loaisach(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Loaisach(int id) {
        this.id = id;
    }

    public Loaisach(String name) {
        this.name = name;
    }

    public Loaisach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
