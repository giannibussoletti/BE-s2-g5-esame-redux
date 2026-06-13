package giannibussoletti.entities;

import giannibussoletti.exceptions.MinPlayerNumberNotFound;
import giannibussoletti.exceptions.NoGameWithThisID;

import java.util.ArrayList;
import java.util.List;

public class Collection {

    static List<Game> gameCollection = new ArrayList<>();

    public static void addGame(Game game) {
        gameCollection.add(game);
    }

    public static Game searchById(String id) throws NoGameWithThisID {
        List<Game> findById = gameCollection.stream().filter(game -> game.getId().equals(id)).toList();
        if (!findById.isEmpty()) return findById.getFirst();
        else throw new NoGameWithThisID(id);

    }

    public static List<Game> searchByPrice(double price) {
        return gameCollection.stream().filter(game -> game.getPrice() <= price).toList();
    }

    public static List<Game> searchByPlayersNumber(int players) throws MinPlayerNumberNotFound {
        List<Game> filterByPlayers = gameCollection.stream().filter(game -> game instanceof Boardgames).filter(game -> ((Boardgames) game).getNumOfPlayers() >= players).toList();
        if (!filterByPlayers.isEmpty()) return filterByPlayers;
        else throw new MinPlayerNumberNotFound();
    }

    public static void deleteByID(String id) {
        gameCollection = gameCollection.stream().filter(game -> !game.getId().equals(id)).toList();
    }


    public static boolean idAlreadyExist(String id) {
        return gameCollection.stream().anyMatch(game -> game.getId().equals(id));
    }

    public static void printCollection() {
        if (gameCollection.isEmpty()) {
            System.out.println("""
                    Non è stato trovato alcun gioco nella lista.
                    Impossibile stimare il prezzo più alto e quello medio.
                    """);
            return;
        }

        List<Game> printBoardgames = gameCollection.stream()
                .filter(game -> game instanceof Boardgames)
                .toList();

        double higherPriceFilter = gameCollection.stream()
                .mapToDouble(Game::getPrice).max()
                .orElseThrow(IllegalStateException::new);

        List<Game> higherPrice = gameCollection.stream()
                .filter(game -> game.getPrice() == higherPriceFilter).toList();

        double averagePrice = gameCollection.stream()
                .mapToDouble(Game::getPrice).average()
                .orElseThrow(IllegalStateException::new);

        if (printBoardgames.isEmpty()) {
            System.out.println(
                    "La collezione ha un totale di: " + gameCollection.size() +
                            "\nNon ci sono giochi da tavolo" +
                            "\nIl gioco più costoso è" + higherPrice.getFirst() +
                            "\nLa media dei prezzi di tutti i giochi è:" + averagePrice + "€"
            );
        } else {
            System.out.println(
                    "La collezione ha un totale di: " + gameCollection.size() +
                            "\n\nIl gioco più costoso è:\n\n" + higherPrice.getFirst() +
                            "\n\nLa media dei prezzi di tutti i giochi è:" + averagePrice + "€\n"
            );
            System.out.println("I Giochi da tavolo presenti sono:");
            printBoardgames.forEach(System.out::println);
        }

    }

}
