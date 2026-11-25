package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;


class SearchController {

    private final Factory factory = new Factory();

    public List<Theatre> search(Location userLocation, String word,
                                SearchBy filter, List<Theatre> allTheatres) {

      
        List<Theatre> nearby = new ArrayList<>();
        for (Theatre theatre : allTheatres) {
            if (theatre.location.isNear(userLocation)) {
                nearby.add(theatre);
            }
        }

     
        Search search = factory.getInstance(filter);
        System.out.println("[Factory] created -> "
                + search.getClass().getSimpleName());

     
        return search.search(nearby, word);
    }
}
