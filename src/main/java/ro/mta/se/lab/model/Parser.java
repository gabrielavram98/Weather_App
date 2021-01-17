package ro.mta.se.lab.model;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import ro.mta.se.lab.interfaces.IParser;

/**
 * Clasa parser se ocupa exclusiv cu extragerea informatiilor dorite din obiectul JSON primit.
 */
public class Parser implements IParser {
     String raw;

     public Parser() {

     }

     /**
      * Aceasta functie extrage temperatura din obiectul JSON.
      * @return
      */
     public String getTemp(){
          JsonObject items =Json.parse(raw).asObject().get("main").asObject();
          return items.get("temp").toString();
     }
     /**
      * Aceasta functie extrage umiditatea din obiectul JSON.
      * @return
      */
     public String getHumidity(){
          JsonObject items =Json.parse(raw).asObject().get("main").asObject();
          return items.get("humidity").toString();
     }
     /**
      * Aceasta functie extrage precipitatiile din obiectul JSON.
      * @return
      */
     public String getPrecipitation(){
          JsonArray items =Json.parse(raw).asObject().get("weather").asArray();
          JsonObject main= items.get(0).asObject();
          return main.get("main").toString();


     }
     /**
      * Aceasta functie extrage viteza vantului din obiectul JSON.
      * @return
      */
     public String getWind(){
          JsonObject items =Json.parse(raw).asObject().get("wind").asObject();
          return items.get("speed").toString();
     }

     public void setRaw(String raw) {
          this.raw = raw;
     }
}
