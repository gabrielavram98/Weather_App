package ro.mta.se.lab.model;

public class City {
    private String Name;
    private String Country;
    private String countryID;
    private float lat;
    private float lng;


    public City(String name, String country, float lat, float lng, String countryID) {
        Name = name;
        Country = country;
        this.lat = lat;
        this.lng = lng;
        this.countryID=countryID;

    }

    public String getCountryID() {
        return countryID;
    }

    public String getName() {
        return Name;
    }
    public int compare(String Country_name){
        if(Country.equals(Country_name))
        {
            return 1;
        }
        else{
            return -1;
        }
    }
    public String getCountry() {
        return Country;
    }
}
