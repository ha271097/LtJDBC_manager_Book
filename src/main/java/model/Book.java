package model;

public class Book {
    private int id;
    private String name;
    private float price;
    private Loaisach loaisach;

    public Book(int id, String name, float price, Loaisach loaisach) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.loaisach = loaisach;
    }

    public Book(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Book(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book(String name, float price, Loaisach loaisach) {
        this.name = name;
        this.price = price;
        this.loaisach = loaisach;
    }

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(String name) {
        this.name = name;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Loaisach getLoaisach() {
        return loaisach;
    }

    public void setLoaisach(Loaisach loaisach) {
        this.loaisach = loaisach;
    }
}
