package com.university.java.semester5.designpatterns.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        
        Location userLocation = new Location("Bangalore", 12.97, 77.59);

        Movie threeIdiots = new Movie("3 Idiots", new Actor("Aamir Khan"));
        Movie rrr = new Movie("RRR", new Actor("Ram Charan"));
        Movie kgf = new Movie("KGF Chapter 2", new Actor("Yash"));
        Movie kantara = new Movie("Kantara", new Actor("Rishab Shetty"));

        Theatre pvr = new Theatre("PVR Orion Mall",
                new Location("Bangalore", 13.01, 77.55));
        pvr.screens.add(screenWith(threeIdiots, rrr));
        pvr.screens.add(screenWith(rrr)); 

        Theatre inox = new Theatre("INOX Garuda Mall",
                new Location("Bangalore", 12.97, 77.61));
        inox.screens.add(screenWith(threeIdiots, kgf));

        Theatre cinepolis = new Theatre("Cinepolis Nexus Koramangala",
                new Location("Bangalore", 12.93, 77.61));
        cinepolis.screens.add(screenWith(kantara, rrr));

        
        Theatre amb = new Theatre("AMB Cinemas",
                new Location("Hyderabad", 17.44, 78.36));
        amb.screens.add(screenWith(rrr, threeIdiots));

        List<Theatre> allTheatres = Arrays.asList(pvr, inox, cinepolis, amb);
        SearchController controller = new SearchController();
        Scanner sc = new Scanner(System.in);

        
        System.out.println("==============================================");
        System.out.println("     MOVIE FINDER  (Factory Design Pattern)");
        System.out.println("==============================================");
        System.out.println("Your location : " + userLocation.city);
        System.out.println("Movies : 3 Idiots, RRR, KGF Chapter 2, Kantara");
        System.out.println("Actors : Aamir Khan, Ram Charan, Yash, "
                + "Rishab Shetty");

        while (true) {
            System.out.println();
            System.out.println("1. Search by movie name");
            System.out.println("2. Search by actor name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextLine()) {
                break; 
            }
            String choice = sc.nextLine().trim();

            SearchBy filter;
            String askFor;

            if (choice.equals("1")) {
                filter = SearchBy.MOVIE_NAME;
                askFor = "movie name";
            } else if (choice.equals("2")) {
                filter = SearchBy.ACTOR_NAME;
                askFor = "actor name";
            } else if (choice.equals("0")) {
                System.out.println("Thanks for using Movie Finder. Bye!");
                break;
            } else {
                System.out.println("Oops! Please enter 1, 2 or 0.");
                continue;
            }

            System.out.print("Enter " + askFor + ": ");
            if (!sc.hasNextLine()) {
                break;
            }
            String word = sc.nextLine().trim();

            List<Theatre> result =
                    controller.search(userLocation, word, filter, allTheatres);
            printResult(word, result);
        }

        sc.close();
    }

    
    private static Screen screenWith(Movie... movies) {
        Screen screen = new Screen();
        for (Movie movie : movies) {
            screen.shows.add(new Show(movie));
        }
        return screen;
    }

    private static void printResult(String word, List<Theatre> result) {
        if (result.isEmpty()) {
            System.out.println("Sorry, no theatre near you is showing \""
                    + word + "\" right now.");
            return;
        }

        System.out.println("Theatres near you for \"" + word + "\":");
        int count = 1;
        for (Theatre theatre : result) {
            System.out.println("  " + count + ". " + theatre.name);
            count++;
        }
    }
}
