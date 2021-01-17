package ro.mta.se.lab.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import ro.mta.se.lab.model.Log;
import ro.mta.se.lab.model.Manager;
import ro.mta.se.lab.model.Parser;
import ro.mta.se.lab.model.weather;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;


import java.io.IOException;

/**
 * Clasa de tip controller weatherController se ocupa cu initializara membrilor interfetei grafice cu valorile aferene
 * si cu managementul evenimentelor care au loc in cadrul aplicatiei.
 *
 */
public class weatherController {

    private weather obj = new weather(new Parser());
    private Manager reader=new Manager();

    @FXML
    private ComboBox<String> countryhandler;
    @FXML
    private ComboBox<String> cityhandler;
    @FXML
    private Label windval;
    @FXML
    private Label tempval;
    @FXML
    private Label precval;
    @FXML
    private Label humidityval;

    /**
     * Aceasta functie initializeaza comboboxul care contine numele tarilor disponibile in aplicatie.
     */
    @FXML
    private void initialize(){

        countryhandler.getItems().addAll(reader.getCountries());
    }


    /**
     * Acest handler initializeaza comboboxul responsabil pentru alegerea oraselor in functie de ce tara a ales utilizatorul.
     */
    public void CountryHandler(){

        cityhandler.getItems().clear();

        cityhandler.getItems().addAll(reader.CitiesByCountry(countryhandler.getValue()));
        cityhandler.setPromptText("Select a city");
    }

    /**
     *
     * Acest handler se ocupa cu extragerea orasului ales de utilizator si se descarcarea datelor corespunzatoare despre vreme.
     */
    public void CityHandler() throws IOException {
        if(!cityhandler.getItems().isEmpty())
            obj.download(cityhandler.getValue(),reader.getCityCountryID(cityhandler.getValue()));
        setValues();

         if(cityhandler.getValue()!=null)
         {
             log();
         }



    }

    /**
     * Aceasta functie seteaza valorile labelurilor din interfata grafica.
     */
    public void setValues(){
        tempval.setText(obj.getTemp() );
        precval.setText(obj.getPrecipitation());
        humidityval.setText(obj.getHumidity());
        windval.setText(obj.getWindspeed());
    }

    /**
     *
     * Aceasta functie se ocupa cu salvarea datelor din cautarea curenta intr-un fisier de log.
     */
    public void log() throws IOException {
        Log logmember=Log.getInstance();
        String search=cityhandler.getValue()+" "+ reader.getCityCountryID(cityhandler.getValue());
        String searchresult=tempval.getText()+" "+precval.getText()+" "+humidityval.getText()+" "+windval.getText();
        logmember.logsave(search+ " "+searchresult );
    }



}
