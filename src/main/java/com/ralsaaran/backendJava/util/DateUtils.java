package com.ralsaaran.backendJava.util;



import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date convertStringToDate(String dateString, String format){
        if(StringUtils.isEmpty(dateString)){
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dob = null;
        try {
            dob = sdf.parse(dateString);
        }catch (Exception e){
            //TODO: print log
        }

        return dob;
    }
}
