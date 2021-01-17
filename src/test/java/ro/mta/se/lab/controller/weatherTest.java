package ro.mta.se.lab.controller;
import ro.mta.se.lab.interfaces.IParser;
import ro.mta.se.lab.model.weather;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.verify;


public class weatherTest {
    IParser mockparser;
    weather instance;



    @Before
    public void setup() {
        mockparser=mock(IParser.class);
        when(mockparser.getHumidity()).thenReturn("90");
        when(mockparser.getPrecipitation()).thenReturn("\"Clouds\"");
        when(mockparser.getTemp()).thenReturn("276.5");
        when(mockparser.getWind()).thenReturn("2.4");
        instance=new weather(mockparser);
    }

    @Test
    public void check()
    {
        assertEquals(instance.getHumidity(),"90%");
        assertEquals(instance.getPrecipitation(),"Clouds");
        assertEquals(instance.getTemp(),"1 Celsius");
        assertEquals(instance.getWindspeed(),"2 km/h");
    }




}
