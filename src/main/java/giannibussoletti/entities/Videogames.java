package giannibussoletti.entities;

import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;

public class Videogames extends Game {
    protected int totalGameLength;
    protected Genres genre;
    protected Platform platform;

    public Videogames(String id, String title, int yearRelease, double price, int totalGameLength, Genres genre, Platform platform) {
        super(id, title, yearRelease, price);
        this.totalGameLength = totalGameLength;
        this.genre = genre;
        this.platform = platform;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public void setTotalGameLength(int totalGameLength) {
        this.totalGameLength = totalGameLength;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDurata totale: " + totalGameLength +
                "\nGenere: " + genre.toString().toLowerCase() +
                "\nPiattaforma: " + platform.toString().toLowerCase() +
                "\n------------------------";

    }
}
