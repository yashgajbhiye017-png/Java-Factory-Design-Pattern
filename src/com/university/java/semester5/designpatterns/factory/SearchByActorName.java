package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;


class SearchByActorName implements Search {

    @Override
    public List<Theatre> search(List<Theatre> theatres, String word) {
        List<Theatre> result = new ArrayList<>();

        for (Theatre theatre : theatres) {
            if (hasActor(theatre, word)) {
                result.add(theatre);
            }
        }
        return result;
    }

    
    private boolean hasActor(Theatre theatre, String actorName) {
        for (Screen screen : theatre.screens) {
            for (Show show : screen.shows) {
                if (show.movie.actor.name.equalsIgnoreCase(actorName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
