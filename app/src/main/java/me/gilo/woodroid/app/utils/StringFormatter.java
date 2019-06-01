package me.gilo.woodroid.app.utils;

import java.text.DecimalFormat;

/**
 * Created by gilo on 1/31/16.
 */
public class StringFormatter {

    public static String formatPrice(float price) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String formattedText = formatter.format(price);
        return "$" + formattedText;
    }

    public static String formatNumber(float price) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String formattedText = formatter.format(price);
        return "" + formattedText;
    }
}
