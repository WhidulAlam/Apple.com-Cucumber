package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth(){
        //Create Date object
        Date d= new Date();

        //Create calendar object G Calender
        Calendar calendar= new GregorianCalendar();

        //set Calender object to current date
        calendar.setTime(d);

        //Create object for SimpleDateFormat. Example(Jan-2023)
        SimpleDateFormat sdf= new SimpleDateFormat("MMM-yyyy");

        //Increment the current Month
        calendar.add(Calendar.MONTH, 1);

        //Generate the date base on the specified object
        String date = sdf.format(calendar.getTime());

        //Returning the value of the month & year in an array
        return date.split("-");


    }
}
