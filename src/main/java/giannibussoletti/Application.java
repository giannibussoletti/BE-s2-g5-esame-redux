package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Collection;
import giannibussoletti.entities.Game;
import giannibussoletti.entities.Videogames;
import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;
import giannibussoletti.exceptions.MinPlayerNumberNotFound;
import giannibussoletti.exceptions.NoGameWithThisID;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

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

        // Aggiunta Videogioco
        System.out.println("Titolo");
        scanner.nextLine();
        int year = 0;
        while (true) {
            System.out.println("Anno");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 1980 && year < 2030) break;
                else {
                    scanner.nextLine();
                    System.out.println("Anno non valido");
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero intero");
            }
        }
        double price = 0;
        while (true) {
            System.out.println("Costo");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price >= 1 && price < 90) break;
                else {
                    scanner.nextLine();
                    System.out.println("Prezzo non valido");
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero");
            }
        }
        int length = 0;
        while (true) {
            System.out.println("Durata");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length >= 1) break;
                else {
                    scanner.nextLine();
                    System.out.println("La durata non può essere minore di 1");
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero");
            }
        }
        Platform platform;
        while (true) {
            System.out.println("Piattaforma di rilascio");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> platform = Platform.PC;
                    case 2 -> platform = Platform.XBOX;
                    case 3 -> platform = Platform.SWITCH;
                    case 4 -> platform = Platform.PLAYSTATION;
                    case 5 -> platform = Platform.MULTIPLE;
                    case 6 -> platform = Platform.ALTRE_PIATTAFORME;
                }
                else {
                    scanner.nextLine();
                    System.out.println("La durata non può essere minore di 1");
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero");
            }
        }


        System.out.println("Genere");
        scanner.nextInt();
        System.out.println("Piattaforma di rilascio");
        scanner.nextInt();
        break;

        // Aggiunta Boardgame
        while (true) {
            System.out.println("Titolo");
            scanner.nextLine();
            System.out.println("Anno");
            scanner.nextInt();
            System.out.println("Costo");
            scanner.nextDouble();
            System.out.println("Lunghezza in Minuti");
            scanner.nextInt();
            System.out.println("Numero minimo di giocatori");
            scanner.nextInt();
            break;
        }


//        System.out.println(Collection.searchById("387492734543543652"));
//        Collection.searchByPrice(80).forEach(System.out::println);
        try {
            Collection.searchByPlayersNumber(30).forEach(System.out::println);
        } catch (MinPlayerNumberNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Collection.searchById("12345678912353163");
        } catch (NoGameWithThisID e) {
            System.out.println(e.getMessage());
        }
        Collection.printCollection();
    }
}
