package ro.mta.se.lab.model;

public class City {
    private String Name;
    private String Country;
    private String countryID;
    private float lat;
    private float lng;

    /**
     * Clasa City se ocupa cu stocarea informatiilor pentru fiecare tara in parte.
     * @param name Numele orasului
     * @param country Numele tarii
     * @param lat coordonata de latitudine
     * @param lng coodronata de longitudine
     * @param countryID ID-ul de identificare al tarii din care face parte orasul.
     */
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
