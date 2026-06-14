package giannibussoletti.entities;

public abstract class Game {
    protected String id;
    protected String title;
    protected int yearRelease;
    protected double price;

    public Game(String id, String title, int yearRelease, double price) {
        this.id = id;
        this.title = title;
        this.yearRelease = yearRelease;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    @Override
    public String toString() {
        return title + ":" +
                "\nID: " + id +
                "\nAnno di rilascio: " + yearRelease +
                "\nPrezzo: " + price + "€";

    }
}
