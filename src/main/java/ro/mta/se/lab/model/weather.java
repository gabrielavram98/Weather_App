package ro.mta.se.lab.model;

import com.eclipsesource.json.JsonValue;
import ro.mta.se.lab.interfaces.IParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class weather {
    private IParser parser;
    public weather(IParser pars){
        parser=pars;
    }
    public void download( String cityname, String countryID) throws IOException {
        StringBuilder result= new StringBuilder();
        System.out.println(cityname);
        System.out.println(countryID);
         URL url= new URL("http://api.openweathermap.org/data/2.5/weather?q="+cityname+","+countryID+"&appid=ea21c3412fd36bf39f93db2d8b711f47");
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null){
            result.append(line);
        }
        rd.close();
        parser.setRaw(result.toString());

    }

    public String getTemp(){

        float temperature=Float.parseFloat(parser.getTemp()) - 275 ;
        int temp_int = (int)temperature;
        return temp_int +" Celsius";
    }
    public String getPrecipitation(){
        return parser.getPrecipitation().substring(1,parser.getPrecipitation().length()-1);
    }
    public String getHumidity(){
        return parser.getHumidity()+"%";
    }
    public String getWindspeed(){
        float windspeed=Float.parseFloat(parser.getWind()) ;
        int wind_int= (int)windspeed;
        return wind_int +" km/h";
    }


}
