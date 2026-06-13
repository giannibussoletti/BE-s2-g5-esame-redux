package giannibussoletti.exceptions;

public class NoGameWithThisID extends Exception {
    public NoGameWithThisID() {
        super("Nessun gioco con questo ID");
    }

    public NoGameWithThisID(String id) {
        super("Nessun gioco con ID: " + id);
    }
}
