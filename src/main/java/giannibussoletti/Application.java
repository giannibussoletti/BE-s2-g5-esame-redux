package giannibussoletti;

import giannibussoletti.entities.*;
import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game1 = new Videogames("5c95bea8-3d58-4cd4-b1aa-96ef93e10d40", "Batman Arkham City", 2020, 130.99, 30, Genres.ACTION, Platform.PC);
        Game game2 = new Videogames("7213fdf5-9a04-428f-9ce7-e74e629942e1", "Expedition 33", 2020, 40.50, 30, Genres.ACTION, Platform.PC);
        Game game3 = new Videogames("b4a8ac27-6146-42ed-9db7-ae182cb11369", "AFK Journey", 2020, 80.99, 30, Genres.ACTION, Platform.PC);
        Game game4 = new Boardgames("3dfaef89-1893-46aa-835c-4f26b871f81a", "Carcassone", 2020, 20, 2, 90);
        Game game5 = new Boardgames("483d8c92-d700-4d9c-b2f7-104df40ea8e6", "Il gioco dell'oca", 2020, 120.50, 4, 90);
        Game game6 = new Boardgames("d052bdc9-c9df-4b23-a3e9-3b2dc2f70fd3", "Cluedo", 2020, 9.95, 6, 90);

        Collection.addGame(game1);
        Collection.addGame(game2);
        Collection.addGame(game3);
        Collection.addGame(game4);
        Collection.addGame(game5);
        Collection.addGame(game6);


        // Aggiunta Gioco


//
        while (true) {
            int mainMenuChoice;
            while (true) {
                System.out.println("""
                        1) Aggiungi un gioco
                        2) Ricerca per ID
                        3) Ricerca i giochi per prezzo massimo
                        4) Ricerca per numero di giocatori
                        5) Rimuovi un gioco
                        6) Aggiorna un gioco
                        7) Stampa le statistiche della collezione
                        0) Esci
                        """);

                if (scanner.hasNextInt()) {
                    mainMenuChoice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Valore non valido");
                    scanner.nextLine();
                }
            }
            switch (mainMenuChoice) {
                case 1 -> Utilities.menuCreateGame();
                case 2 -> Utilities.menuSearchByID();
                case 3 -> System.out.println("sas");
                case 4 -> Utilities.menuNumOfPlayerSearch();
                case 5 -> Utilities.menuDeleteByID();
                case 7 -> Collection.printCollection();
                case 0 -> System.exit(0);
                default -> System.out.println("Scelta non valida");
            }
        }
        /*
____________________________________________________________________
        System.out.println(Collection.searchById("387492734543543652"));
        Collection.searchByPrice(80).forEach(System.out::println);



        Collection.printCollection();
*/
    }
}
