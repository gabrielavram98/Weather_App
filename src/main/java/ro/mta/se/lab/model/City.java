package ro.mta.se.lab.model;

public class City {
    private String Name;
    private String Country;
    private float lat;
    private float lng;

    public City(String name, String country, float lat, float lng) {
        Name = name;
        Country = country;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }
}
