package giannibussoletti.exceptions;

public class MinPlayerNumberNotFound extends Exception {
    public MinPlayerNumberNotFound() {
        super("Nessun gioco con questo numero di giocatori minimi");
    }
}
