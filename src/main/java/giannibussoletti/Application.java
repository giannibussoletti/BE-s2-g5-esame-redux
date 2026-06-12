package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Collection;
import giannibussoletti.entities.Game;
import giannibussoletti.entities.Videogames;
import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;

public class Application {

    public static void main(String[] args) {


        Game game1 = new Videogames("1234567891232153163", "Prova", 2020, 20.99, 30, Genres.ACTION, Platform.PC);
        Game game2 = new Videogames("1234567891264523266", "Prova", 2020, 40.50, 30, Genres.ACTION, Platform.PC);
        Game game3 = new Videogames("1234567891232176538", "Prova", 2020, 80.99, 30, Genres.ACTION, Platform.PC);
        Game game4 = new Boardgames("32874354354734983", "Prova board", 2020, 20, 3, 90);
        Game game5 = new Boardgames("32874927234235489", "Prova board", 2020, 120.50, 3, 90);
        Game game6 = new Boardgames("3287492734543543652", "Prova board", 2020, 9.95, 3, 90);

        Collection.addGame(game1);
        Collection.addGame(game2);
        Collection.addGame(game3);
        Collection.addGame(game4);
        Collection.addGame(game5);
        Collection.addGame(game6);

        System.out.println(Collection.searchById("3287492734543543652"));
        Collection.searchByPrice(80.00).forEach(System.out::println);
    }
}
