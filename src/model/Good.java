package model;

/**
 * Created by Andrey on 25.01.2015.
 */
public class Good {
    private final int id;
    private final String name;
    private final int price;

    //TODO how to use setters instead of this.id = id?
    public Good(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}


