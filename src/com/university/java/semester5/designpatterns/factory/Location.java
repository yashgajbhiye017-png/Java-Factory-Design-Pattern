package com.university.java.semester5.designpatterns.factory;

class Location {
    String city;
    double lat, lng;

    Location(String city, double lat, double lng) {
        this.city = city;
        this.lat = lat;
        this.lng = lng;
    }

    
    boolean isNear(Location other) {
        return Math.abs(this.lat - other.lat) <= 0.2
                && Math.abs(this.lng - other.lng) <= 0.2;
    }
}
