package giannibussoletti.entities;

public class Boardgames extends Game {
    protected int numOfPlayers;
    protected int totalGameLength;

    public Boardgames(String id, String title, int yearRelease, double price, int numOfPlayers, int totalGameLength) {
        super(id, title, yearRelease, price);
        this.numOfPlayers = numOfPlayers;
        this.totalGameLength = totalGameLength;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setTotalGameLength(int totalGameLength) {
        this.totalGameLength = totalGameLength;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNumero minimo di giocatori: " + numOfPlayers +
                "\nTempo medio di una partita: " + totalGameLength + "min." +
                "\n------------------------";
    }
}
