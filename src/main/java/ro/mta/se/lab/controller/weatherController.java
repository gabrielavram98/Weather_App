package ro.mta.se.lab.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import ro.mta.se.lab.model.Manager;
import ro.mta.se.lab.model.weather;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class weatherController {
    private weather obj= new weather();
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
    @FXML
    private void initialize(){
        countryhandler.getItems().addAll(reader.getCountries());
    }





    public void CountryHandler(){
        cityhandler.setPromptText("Select a city");
        cityhandler.getItems().clear();
        cityhandler.getItems().addAll(reader.CitiesByCountry(countryhandler.getValue()));
    }

    public void CityHandler() throws IOException {
        if(!cityhandler.getItems().isEmpty())
            obj.download(cityhandler.getValue(),reader.getCityCountryID(cityhandler.getValue()));
        setValues();
    }
    public void setValues(){
        tempval.setText(obj.getTemp() );
        precval.setText(obj.getPrecipitation());
        humidityval.setText(obj.getHumidity());
        windval.setText(obj.getWindspeed());
    }



}
