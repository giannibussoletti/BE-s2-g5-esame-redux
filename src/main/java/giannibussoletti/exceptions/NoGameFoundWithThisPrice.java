package giannibussoletti.exceptions;

public class NoGameFoundWithThisPrice extends RuntimeException {
    public NoGameFoundWithThisPrice() {
        super("Nessun gioco trovato con il prezzo minimo indicato.");
    }
}
