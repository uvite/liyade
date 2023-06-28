package com.ruoyi.project.app.controller.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateValid {
    public static boolean IsValidDate(String str) {

        Date date1 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        try {
           date1= sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date;

        date = dateFormat.format(date1);



        return date!=null?true:false;
    }
}
