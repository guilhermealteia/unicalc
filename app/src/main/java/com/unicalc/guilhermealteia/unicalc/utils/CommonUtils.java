package com.unicalc.guilhermealteia.unicalc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {

    public static void waitTime(int millis) {
        long timeAntes = Calendar.getInstance().getTimeInMillis();
//        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmmssSSSSSS");
        long timeAtual = 0L;
        do {
            timeAtual = Calendar.getInstance().getTimeInMillis();
        }
        while((timeAntes + millis) > timeAtual );
        System.out.println("timeAntes: "+ timeAntes);
        System.out.println("timeAtual: "+ timeAtual);
    }

}
