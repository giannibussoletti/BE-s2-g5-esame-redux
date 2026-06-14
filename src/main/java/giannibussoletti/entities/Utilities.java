package giannibussoletti.entities;

import giannibussoletti.enums.Genres;
import giannibussoletti.enums.Platform;
import giannibussoletti.exceptions.MinPlayerNumberNotFound;
import giannibussoletti.exceptions.NoGameWithThisID;

import java.util.Scanner;
import java.util.UUID;

public final class Utilities {
    static Scanner scanner = new Scanner(System.in);


    public static void menuCreateGame() {
        int gameOrBoard;
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
                if (price >= 1 && price < 100) break;
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
            }

            // Aggiunta Boardgames
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
                Collection.addGame(new Boardgames(gameID, title, year, price, boardNumOfPlayers, boardTotalGameLength));
            }
        }
        scanner.nextLine();
    }

    public static void menuSearchByID() {
        System.out.println("Inserisci l'id da cercare");
        try {
            String idToFind = scanner.nextLine();
            Collection.CollectionSearchById(idToFind);
        } catch (NoGameWithThisID e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuNumOfPlayerSearch() {
        int numOfPlayers;
        while (true) {
            System.out.println("Dimmi il numero minimo di giocatori (min 2 - max 10)");
            if (scanner.hasNextInt()) {
                numOfPlayers = scanner.nextInt();
                if (numOfPlayers >= 2 && numOfPlayers <= 10) {
                    try {
                        Collection.searchByPlayersNumber(numOfPlayers).forEach(System.out::println);
                    } catch (MinPlayerNumberNotFound e) {
                        System.out.println(e.getMessage());
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
    }

    public static void menuDeleteByID() {
        System.out.println("Inserisci l'id del gioco da cancellare");
        String idToDelete = scanner.nextLine();
        try {
            Collection.deleteByID(idToDelete);
        } catch (NoGameWithThisID e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuUpdateGames() {
        System.out.println("Inserisci l'id del gioco da aggiornare");
        String idGameToUpdate = scanner.nextLine();
        try {
            Game gameToUpdate = Collection.UpdateGame(idGameToUpdate);
            int choice;
            String repeatChoice = "y";
            do {
                if (gameToUpdate instanceof Videogames) {
                    System.out.println("""
                            Cosa vuoi aggiornare del Videogioco?
                                1) Titolo
                                2) Anno di uscita
                                3) Prezzo
                                4) Durata totale del gioco
                                5) Genere
                                6) Piattaforma
                            """);
                } else {
                    System.out.println("""
                            Cosa vuoi aggiornare del Videogioco?
                                1) Titolo
                                2) Anno di uscita
                                3) Prezzo
                                4) Durata totale del gioco
                                5) Numero di giocatori
                            """);
                }
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Scrivi il nuovo titolo");
                            gameToUpdate.setTitle(scanner.nextLine());
                            System.out.println("Titolo Aggiornato con successo!");

                        }
                        case 2 -> {
                            while (true) {
                                System.out.println("Scrivi il nuovo anno");
                                if (scanner.hasNextInt()) {
                                    int year = scanner.nextInt();
                                    scanner.nextLine();
                                    if (year >= 1980 && year <= 2030) {
                                        System.out.println("Anno Aggiornato con successo!");
                                        gameToUpdate.setYearRelease(year);
                                        break;
                                    } else {
                                        System.out.println("Anno non valido");
                                    }
                                } else {
                                    System.out.println("Valore non valido");
                                    scanner.nextLine();
                                }
                            }
                        }
                        case 3 -> {
                            while (true) {
                                System.out.println("Quanto costa?");
                                if (scanner.hasNextDouble()) {
                                    double price = scanner.nextDouble();
                                    scanner.nextLine();
                                    if (price >= 1) {
                                        gameToUpdate.setPrice(price);
                                        break;
                                    } else {
                                        System.out.println("Prezzo non valido");
                                        scanner.nextLine();
                                    }
                                } else {
                                    System.out.println("Valore non valido, inserisci un numero");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }
                    if (gameToUpdate instanceof Videogames) {
                        switch (choice) {
                            case 4 -> {
                                while (true) {
                                    System.out.println("Quanto è la nuova durata?");
                                    if (scanner.hasNextInt()) {
                                        int videogameLength = Integer.parseInt(scanner.nextLine());
                                        if (videogameLength >= 1) {
                                            ((Videogames) gameToUpdate).setTotalGameLength(videogameLength);
                                            break;
                                        } else {
                                            System.out.println("La durata non può essere minore di 1");
                                            scanner.nextLine();
                                        }
                                    } else {
                                        System.out.println("Valore non valido, inserisci un numero");
                                        scanner.nextLine();
                                    }
                                }
                            }
                            case 5 -> {
                                while (true) {
                                    System.out.println("Quale è il nuovo genere principale?");
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
                                        int choiceGenre = scanner.nextInt();
                                        scanner.nextLine();
                                        if (choiceGenre <= 9 && choiceGenre >= 1) {
                                            switch (choiceGenre) {
                                                case 1 -> ((Videogames) gameToUpdate).setGenre(Genres.ACTION);
                                                case 2 -> ((Videogames) gameToUpdate).setGenre(Genres.HORROR);
                                                case 3 -> ((Videogames) gameToUpdate).setGenre(Genres.COZY);
                                                case 4 -> ((Videogames) gameToUpdate).setGenre(Genres.PUZZLE);
                                                case 5 -> ((Videogames) gameToUpdate).setGenre(Genres.RPG);
                                                case 6 -> ((Videogames) gameToUpdate).setGenre(Genres.JRPG);
                                                case 7 -> ((Videogames) gameToUpdate).setGenre(Genres.STEALTH);
                                                case 8 ->
                                                        ((Videogames) gameToUpdate).setGenre(Genres.FIRST_PERSON_SHOOTER);
                                                case 9 -> ((Videogames) gameToUpdate).setGenre(Genres.MMO);
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
                            }
                            case 6 -> {
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
                                        int platformChoice = scanner.nextInt();
                                        if (platformChoice <= 6 && platformChoice >= 1) {
                                            switch (platformChoice) {
                                                case 1 -> ((Videogames) gameToUpdate).setPlatform(Platform.PC);
                                                case 2 -> ((Videogames) gameToUpdate).setPlatform(Platform.XBOX);
                                                case 3 -> ((Videogames) gameToUpdate).setPlatform(Platform.SWITCH);
                                                case 4 -> ((Videogames) gameToUpdate).setPlatform(Platform.PLAYSTATION);
                                                case 5 -> ((Videogames) gameToUpdate).setPlatform(Platform.MULTIPLE);
                                                case 6 ->
                                                        ((Videogames) gameToUpdate).setPlatform(Platform.ALTRE_PIATTAFORME);
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
                            }
                        }
                    } else {
                        switch (choice) {
                            case 4 -> {
                                while (true) {
                                    System.out.println("Quanto è la nuova durata?");
                                    if (scanner.hasNextInt()) {
                                        int boardgameLength = scanner.nextInt();
                                        scanner.nextLine();
                                        if (boardgameLength >= 1) {
                                            ((Boardgames) gameToUpdate).setTotalGameLength(boardgameLength);
                                            break;
                                        } else {
                                            System.out.println("La durata non può essere minore di 1");
                                        }
                                    } else {
                                        System.out.println("Valore non valido, inserisci un numero");
                                        scanner.nextLine();
                                    }
                                }
                            }
                            case 5 -> {
                                while (true) {
                                    System.out.println("Quale è il numero minimo di giocatori? (espressi in numeri)");
                                    if (scanner.hasNextInt()) {
                                        int boardNumOfPlayers = scanner.nextInt();
                                        scanner.nextLine();
                                        if (boardNumOfPlayers >= 2 && boardNumOfPlayers <= 10) {
                                            ((Boardgames) gameToUpdate).setNumOfPlayers(boardNumOfPlayers);
                                            break;
                                        } else {
                                            System.out.println("min. 2 giocatori\nmax. 10 giocatori");
                                        }
                                    } else {
                                        System.out.println("Valore non valido");
                                        scanner.nextLine();
                                    }
                                }
                            }
                        }
                    }

                    System.out.println("Vuoi aggiornare qualcos'altro? y o n");
                    if (scanner.nextLine().equalsIgnoreCase("n")) {
                        repeatChoice = "n";
                    }
                } else {
                    System.out.println("Valore non valido");
                    scanner.nextLine();
                }
            } while (repeatChoice.equalsIgnoreCase("y"));

        } catch (NoGameWithThisID e) {
            System.out.println(e.getMessage());
        }
    }

    public static void menuSearchByPrice() {
        while (true) {
            System.out.println("Quale è il prezzo massimo che vuoi cercare?");
            if (scanner.hasNextInt()) {
                int price = scanner.nextInt();
                if (price >= 1) {
                    System.out.println("I giochi con prezzo massimo " + price + "€");
                    Collection.searchByPrice(price).forEach(System.out::println);
                    break;
                } else {
                    System.out.println("Il valore deve essere di almeno 1");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Valore non valido");
                scanner.nextLine();
            }
        }
    }

}

