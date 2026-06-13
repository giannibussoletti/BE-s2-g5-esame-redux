package giannibussoletti;

import giannibussoletti.entities.Boardgames;
import giannibussoletti.entities.Collection;
import giannibussoletti.entities.Game;
import giannibussoletti.entities.Videogames;
import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

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

        int gameOrBoard;
//
        while (true) {
            System.out.println("""
                    Cosa vuoi aggiungere?
                    1) Videogioco
                    2)Gioco da tavolo?""");
            if (scanner.hasNextInt()) {
                gameOrBoard = scanner.nextInt();
                scanner.nextLine();
                if (gameOrBoard == 1 || gameOrBoard == 2) {
                    break;
                } else {
                    System.out.println("Valore non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();
            }
        }

        String gameID;
        while (true) {
            String randomIdSeed = UUID.randomUUID().toString();
            if (!Collection.idAlreadyExist(randomIdSeed)) {
                gameID = randomIdSeed;
                break;
            }
        }

        System.out.println("Dimmi il titolo:");
        String title = scanner.nextLine();

        int year;
        while (true) {
            System.out.println("In che anno è stato rilasciato?");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 1980 && year < 2030) break;
                else {
                    System.out.println("Anno non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero intero");
                scanner.nextLine();
            }
        }
        double price;
        while (true) {
            System.out.println("Quanto costa?");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price >= 1 && price < 90) break;
                else {
                    System.out.println("Prezzo non valido");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido, inserisci un numero");
                scanner.nextLine();
            }
        }
        //Variabili videogioco
        int videogameLength;
        Platform videogamePlatform;
        Genres videogameGenre;

        //Variabili gioco da tavolo
        int boardNumOfPlayers;
        int boardTotalGameLength;

        switch (gameOrBoard) {
            case 1 -> {
                // Aggiunta Videogioco
                while (true) {
                    System.out.println("Quanto dura in ore il gioco?");
                    if (scanner.hasNextInt()) {
                        videogameLength = scanner.nextInt();
                        if (videogameLength >= 1) break;
                        else {
                            System.out.println("La durata non può essere minore di 1");
                            scanner.nextLine();
                        }
                    } else {
                        System.out.println("Valore non valido, inserisci un numero");
                        scanner.nextLine();
                    }
                }

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
                                case 1 -> videogamePlatform = Platform.PC;
                                case 2 -> videogamePlatform = Platform.XBOX;
                                case 3 -> videogamePlatform = Platform.SWITCH;
                                case 4 -> videogamePlatform = Platform.PLAYSTATION;
                                case 5 -> videogamePlatform = Platform.MULTIPLE;
                                case 6 -> videogamePlatform = Platform.ALTRE_PIATTAFORME;
                                default -> throw new IllegalStateException("Valore non valido");
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
                                case 1 -> videogameGenre = Genres.ACTION;
                                case 2 -> videogameGenre = Genres.HORROR;
                                case 3 -> videogameGenre = Genres.COZY;
                                case 4 -> videogameGenre = Genres.PUZZLE;
                                case 5 -> videogameGenre = Genres.RPG;
                                case 6 -> videogameGenre = Genres.JRPG;
                                case 7 -> videogameGenre = Genres.STEALTH;
                                case 8 -> videogameGenre = Genres.FIRST_PERSON_SHOOTER;
                                case 9 -> videogameGenre = Genres.MMO;
                                default -> throw new IllegalStateException("Valore non valido");
                            }
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

                Collection.addGame(new Videogames(gameID, title, year, price, videogameLength, videogameGenre, videogamePlatform));
                System.out.println(new Videogames(gameID, title, year, price, videogameLength, videogameGenre, videogamePlatform));
            }

            // Aggiunta Boardgame
            case 2 -> {
                while (true) {
                    System.out.println("Quale è il numero minimo di giocatori? (espressi in numeri)");
                    if (scanner.hasNextInt()) {
                        boardNumOfPlayers = scanner.nextInt();
                        if (boardNumOfPlayers >= 2 && boardNumOfPlayers <= 10) break;
                        else System.out.println("min. 2 giocatori\nmax. 10 giocatori");
                    } else {
                        System.out.println("Valore non valido");
                    }
                }

                while (true) {
                    System.out.println("Quanti minuti dura una partita?");
                    if (scanner.hasNextInt()) {
                        boardTotalGameLength = scanner.nextInt();
                        if (boardTotalGameLength > 0) break;
                        else System.out.println("il gioco non può durare 0 minuti");
                    } else {
                        System.out.println("Valore non valido");
                    }
                }
            }
        }

        //____________________________________________________________________
//        System.out.println(Collection.searchById("387492734543543652"));
//        Collection.searchByPrice(80).forEach(System.out::println);
//        try {
//            Collection.searchByPlayersNumber(30).forEach(System.out::println);
//        } catch (MinPlayerNumberNotFound e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            Collection.searchById("12345678912353163");
//        } catch (NoGameWithThisID e) {
//            System.out.println(e.getMessage());
//        }
//        Collection.printCollection();
    }
}
