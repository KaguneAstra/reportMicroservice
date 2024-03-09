package org.reports.classes;

public class Location {
    public String locationName;
    public double lat;
    public double lng;

    public Location(String name, double latitude, double longitude){
        locationName = name;
        lat = latitude;
        lng = longitude;
    }
    //TODO default constructor for testing, remove later
    private static int counter = 0;
    public Location(){
        locationName = "Test name " + counter++;
        lat = 69.6;
        lng = 420.0;
    }
}
