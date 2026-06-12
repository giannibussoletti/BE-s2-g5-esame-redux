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

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    
    @Override
    public String toString() {
        return "\n" + title + ":" +
                "\nID: " + id +
                "\nNome: " + title + '\'' +
                "\nAnno di rilascio: " + yearRelease +
                "\nPrezzo:" + price;
    }
}
