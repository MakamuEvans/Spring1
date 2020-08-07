package co.ke.makamuevans.jav1.utilities.Helpers.Formatters;

import org.apache.tomcat.jni.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static String formatDateOne(LocalDateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm");
        return dateTimeFormatter.format(date);
    }

    public static String formatdateTwo(LocalDateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dateTimeFormatter.format(date);
    }

}
