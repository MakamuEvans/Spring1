package co.ke.makamuevans.jav1.utilities.Helpers.Formatters;

import org.apache.tomcat.jni.Local;
import org.springframework.lang.NonNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    /**
     * Mon, 15 Aug 2020 10:10
     * @param date
     * @return
     */
    public static String formatDateOne(@NonNull LocalDateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm");
        return dateTimeFormatter.format(date);
    }

    /**
     * 01 Jan 2020
     * @param date
     * @return
     */
    public static String formatDateTwo(@NonNull LocalDateTime date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dateTimeFormatter.format(date);
    }

}
