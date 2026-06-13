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

        // Aggiunta Gioco
        String gameID;
        while (true) {
            String randomIdSeed = Long.toString(random.nextLong());
            if (Collection.idCheck(randomIdSeed)) {
                gameID = randomIdSeed;
                break;
            }
        }

        System.out.println("Dimmi il titolo:");
        String title = scanner.nextLine();

        int year = 0;
        while (true) {
            System.out.println("In che anno è stato rilasciato?");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 1980 && year < 2030) break;
                else {
                    scanner.next();
                    System.out.println("Anno non valido");
                }
            } else {
                scanner.next();
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
                    scanner.next();
                    System.out.println("Prezzo non valido");
                }
            } else {
                scanner.next();
                System.out.println("Valore non valido, inserisci un numero");
            }
        }
        // Aggiunta Videogioco
        int length = 0;
        while (true) {
            System.out.println("Quanto dura in ore il gioco?");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length >= 1) break;
                else {
                    scanner.next();
                    System.out.println("La durata non può essere minore di 1");
                }
            } else {
                scanner.next();
                System.out.println("Valore non valido, inserisci un numero");
            }
        }

        Platform platform;
        while (true) {
            System.out.println("Su quale piattaforma è stato rilasciato? Usa i numeri indicati");
            System.out.println("""
                    1) PC
                    2) XBOX
                    3) SWITCH
                    4) PLAYSTATION
                    5) MULTIPLE
                    6) ALTRE PIATTAFORME""");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice <= 6 && choice >= 1) {
                    switch (choice) {
                        case 1 -> platform = Platform.PC;
                        case 2 -> platform = Platform.XBOX;
                        case 3 -> platform = Platform.SWITCH;
                        case 4 -> platform = Platform.PLAYSTATION;
                        case 5 -> platform = Platform.MULTIPLE;
                        case 6 -> platform = Platform.ALTRE_PIATTAFORME;
                    }
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Numero non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();

            }
        }

        Genres genre;
        while (true) {
            System.out.println("Quale è il suo genere principale? Usa i numeri indicati");
            System.out.println(
                    """
                            1) ACTION,
                            2) HORROR,
                            3) COZY,
                            4) PUZZLE,
                            5) RPG,
                            6) JRPG,
                            7) STEALTH,
                            8) FIRST_PERSON_SHOOTER,
                            9) MMO"""
            );
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice <= 9 && choice >= 1) {
                    switch (choice) {
                        case 1 -> genre = Genres.ACTION;
                        case 2 -> genre = Genres.HORROR;
                        case 3 -> genre = Genres.COZY;
                        case 4 -> genre = Genres.PUZZLE;
                        case 5 -> genre = Genres.RPG;
                        case 6 -> genre = Genres.JRPG;
                        case 7 -> genre = Genres.STEALTH;
                        case 8 -> genre = Genres.FIRST_PERSON_SHOOTER;
                        case 9 -> genre = Genres.MMO;
                    }
                    break;

                } else {
                    System.out.println("Numero non valido");
                    scanner.next();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.next();

            }


        }

        // Aggiunta Boardgame
        int numOfPlayers = 0;
        while (true) {
            System.out.println("Quale è il numero minimo di giocatori? (espressi in numeri)");
            if (scanner.hasNextInt()) {
                numOfPlayers = scanner.nextInt();
                if (numOfPlayers >= 2 && numOfPlayers <= 10) break;
                else System.out.println("min. 2 giocatori\nmax. 10 giocatori");
            } else {
                System.out.println("Valore non valido");
            }
        }
        int totalGameLength = 0;
        while (true) {
            System.out.println("Quanti minuti dura una partita?");
            if (scanner.hasNextInt()) {
                totalGameLength = scanner.nextInt();
                if (totalGameLength > 0) break;
                else System.out.println("il gioco non può durare 0 minuti");
            } else {
                System.out.println("Valore non valido");
            }
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
