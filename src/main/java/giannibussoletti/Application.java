package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Collection;
import giannibussoletti.entities.Game;
import giannibussoletti.entities.Videogames;
import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;
import giannibussoletti.exceptions.MinPlayerNumberNotFound;

public class Application {

    public static void main(String[] args) throws MinPlayerNumberNotFound {


        Game game1 = new Videogames("1234567891232153163", "Batman Arkam City", 2020, 130.99, 30, Genres.ACTION, Platform.PC);
        Game game2 = new Videogames("1234567891264523266", "Expedition 33", 2020, 40.50, 30, Genres.ACTION, Platform.PC);
        Game game3 = new Videogames("1234567891232176538", "AFK Journey", 2020, 80.99, 30, Genres.ACTION, Platform.PC);
        Game game4 = new Boardgames("32874354354734983", "Carcassone", 2020, 20, 2, 90);
        Game game5 = new Boardgames("32874927234235489", "Il gioco dell'oca", 2020, 120.50, 4, 90);
        Game game6 = new Boardgames("3287492734543543652", "Cluedo", 2020, 9.95, 6, 90);

        Collection.addGame(game1);
        Collection.addGame(game2);
        Collection.addGame(game3);
        Collection.addGame(game4);
        Collection.addGame(game5);
        Collection.addGame(game6);

//        System.out.println(Collection.searchById("387492734543543652"));
//        Collection.searchByPrice(80).forEach(System.out::println);
        try {
            Collection.searchByPlayersNumber(30).forEach(System.out::println);
        } catch (MinPlayerNumberNotFound e) {
            System.out.println(e.getMessage());
        }
//        Collection.deleteByID("1234567891232153163");
//        Collection.printCollection();
    }
}
