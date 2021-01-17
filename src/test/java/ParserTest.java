import org.junit.Before;
import org.junit.rules.Timeout;
import ro.mta.se.lab.model.Parser;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class ParserTest {

        Parser parser= new Parser();
        @Before
       public void init() throws FileNotFoundException {
            File f=new File("src/test/java/parsetest.txt");
            Scanner scan = new Scanner(f);
           StringBuilder line = new StringBuilder();

            while(scan.hasNextLine()) {
                line.append(scan.next());
            }
            parser.setRaw(line.toString());
        }
        @Test
        public void testPrec(){
            assertEquals(parser.getPrecipitation(),"\"Snow\"");
        }
        @Test
        public void testHumidity(){
            assertEquals(parser.getHumidity(),"85");
        }
        @Test
        public void testWind(){
            assertEquals(parser.getWind(),"1.03");
        }
        @Test
        public void testTemp(){
            assertEquals(parser.getTemp(),"265.99");
        }



}
