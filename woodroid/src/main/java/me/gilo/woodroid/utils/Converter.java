package me.gilo.woodroid.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {

    public static String getDateString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return  sdf.format(date);
    }
}
