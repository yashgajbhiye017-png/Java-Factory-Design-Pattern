package com.university.java.semester5.designpatterns.factory;


class Factory {

    public Search getInstance(SearchBy filter) {
        switch (filter) {
            case MOVIE_NAME:
                return new SearchByMovieName();
            case ACTOR_NAME:
                return new SearchByActorName();
            default:
                throw new IllegalArgumentException("Invalid search: " + filter);
        }
    }
}
