package com.example.e_medics;

public class FacilitiesDatabase {
    public Double Lat;
    public String Location;
    public Double Longitude;
    public String Name;
    public String Town;

    public FacilitiesDatabase() {
    }

    public FacilitiesDatabase(String name, String location, String town, Double lat, Double longitude) {
        this.Name = name;
        this.Location = location;
        this.Town = town;
        this.Lat = lat;
        this.Longitude = longitude;
    }
}
