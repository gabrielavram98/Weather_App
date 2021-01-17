package ro.mta.se.lab.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private String file;
    public static Log obj;
    private Log(){
        file="log.txt";
    }
    public static Log getInstance(){
        if(obj==null)
        {
            obj= new Log();
        }
        return obj;
    }
    public String getDateAndTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String strDateTime = dtf.format(now).toString();
        String newStr="[ " + strDateTime + " ] ";
        return newStr;
    }
    public void logsave(String message) throws IOException {
        File f;
        f = new File("src/main/java/ro/mta/se/lab/model/log.txt");
        FileWriter fwr=null;
        fwr =new FileWriter(f,true);
        String datetime=getDateAndTime();
        String logsaved=datetime + message+ "\n";
        fwr.write(logsaved);
        fwr.close();

    }
}
