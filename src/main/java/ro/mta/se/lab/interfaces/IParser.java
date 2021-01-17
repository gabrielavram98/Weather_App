package ro.mta.se.lab.interfaces;

public interface IParser {
    String getTemp();
    String getHumidity();
    String getPrecipitation();
    String getWind();
    void setRaw(String raw);




}
