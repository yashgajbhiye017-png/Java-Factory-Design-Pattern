package com.university.java.semester5.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;


class SearchByMovieName implements Search {

    @Override
    public List<Theatre> search(List<Theatre> theatres, String word) {
        List<Theatre> result = new ArrayList<>();

        for (Theatre theatre : theatres) {
            if (isPlaying(theatre, word)) {
                result.add(theatre);
            }
        }
        return result;
    }


    private boolean isPlaying(Theatre theatre, String movieName) {
        for (Screen screen : theatre.screens) {
            for (Show show : screen.shows) {
                if (show.movie.movieName.equalsIgnoreCase(movieName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
