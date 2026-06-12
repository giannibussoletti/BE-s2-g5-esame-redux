package giannibussoletti.entities;

import java.util.ArrayList;
import java.util.List;

public class Collection {

    static List<Game> gameCollection = new ArrayList<>();

    public static void addGame(Game game) {
        gameCollection.add(game);
    }

    public static Game searchById(String id) {
        List<Game> findById = gameCollection.stream().filter(game -> game.getId().equals(id)).toList();
        if (findById.size() != 1) {
            System.out.println("c'è più di un gioco con questo id");
            return null;
        } else {
            return findById.getFirst();
        }
    }

    public static List<Game> searchByPrice(double price) {
        return gameCollection.stream().filter(game -> game.getPrice() < price).toList();
    }

    public static List<Game> searchByPlayersNumber(int players) {
        List<Game> filterByPlayers = gameCollection.stream().filter(game -> game instanceof Boardgames).filter(game -> ((Boardgames) game).getNumOfPlayers() >= players).toList();
        if (!filterByPlayers.isEmpty()) return filterByPlayers;
        else {
            System.out.println("Non è stato trovato nessun gioco con questo numero minimo di giocatori");
            return filterByPlayers;
        }
    }

}
