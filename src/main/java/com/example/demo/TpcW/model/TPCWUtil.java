package com.example.demo.TpcW.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TPCWUtil {

    private static final String[] digS = {
            "BA", "OG", "AL", "RI", "RE", "SE", "AT", "UL", "IN", "NG"
    };
    public final static SimpleDateFormat ORACLE_DATE_FORMATTER = new SimpleDateFormat("'to_date('''dd-MM-yyyy''', ''dd-mm-yyyy'')'");

    public static String DigSyl(int d, int n) {
        String s = "";
        if (n == 0) {
            return (DigSyl(d));
        }
        for (; n > 0; n--) {
            int c = d % 10;
            s = digS[c] + s;
            d = d / 10;
        }
        return (s);
    }

    private static String DigSyl(int d) {
        String s = "";
        for (; d != 0; d = d / 10) {
            int c = d % 10;
            s = digS[c] + s;
        }
        return (s);
    }

    public static String formatDate(Date d) {
        return ORACLE_DATE_FORMATTER.format(d);
    }

    private static final int NUM_ITEMS = 10000;
    private static Random rand = new Random();

    public static int getRandomI_ID() {
        Double temp = new Double(Math.floor(rand.nextFloat() * NUM_ITEMS));
        return temp.intValue();
    }
}