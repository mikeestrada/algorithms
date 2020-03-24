package com.algorithms.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
    static String timeConversion(String s) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");

        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = null;
        try {
            date = parseFormat.parse(s);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return displayFormat.format(date);
    }
}
