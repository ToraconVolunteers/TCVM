/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sys.Core.Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 
 * @author TheHoudhini
 * @date Oct 15, 2013
 */
public class DateAndTime {
    
    private static String startTime;
    
    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM'/'dd'/'yyyy");
        return sdf.format(cal.getTime());
    }

    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(cal.getTime());
    }
    
    public static String getDateAndTime() {
        return getDate() + " " + getTime();
    }

    public static float shiftCompletionTimeDifference(String shiftStart, String shiftEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date start, end;
        float diff, diffMinutes, diffTotal = 0;
        try {
            start = sdf.parse(shiftStart);
            end = sdf.parse(shiftEnd);
            diff = end.getTime() - start.getTime();
            diffMinutes = diff / (60 * 1000);
            diffTotal = diffMinutes/60;
        } catch (Exception ex) {
            
        }
        return diffTotal;
    }
        
    public static String getConDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM'/'dd'/'yyyy");
        try {
            Date today = sdf.parse(getDate());
            // the following dates must be specified
            Date conDay0 = sdf.parse("03/07/2014"); // friday (registration)
            Date conDay1 = sdf.parse("03/08/2014"); // saturday
            Date conDay2 = sdf.parse("03/09/2014"); // sunday
            // compare today's date with the ones specified to identify the significance
            if(today.compareTo(conDay2)>0){
        		return "Post-Con";
        	}else if(today.compareTo(conDay1)<0){
        		return "Pre-Con";
        	}else if(today.compareTo(conDay0)==0){
        		return "Day 0 - Fri";
        	}else if(today.compareTo(conDay1)==0){
        		return "Day I - Sat";
        	}else if(today.compareTo(conDay2)==0){
        		return "Day II - Sun";
        	}
        } catch (Exception ex) {
            
        }
        return "Unknown";
    }
    
    // set the start time of the application (usually called by MainUI at start)
    public static void setStartTime() {
        startTime = getTime();
    }
    
    // calculates the total current runtime of the application
    public static String runtime() {
        // formalities and declarations
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        DecimalFormat df = new DecimalFormat("##");
        Date start, now;
        long diff, diffSeconds, diffMinutes, diffHours;
        String runtime = "";
        try {
            start = sdf.parse(startTime);
            now = sdf.parse(getTime());
            // calculates time difference between start and now in milliseconds
            diff = now.getTime() - start.getTime();
            // calculates time difference between start and now in seconds, minutes, and hours
            diffSeconds = diff / 1000 % 60; // seconds
            diffMinutes = diff / (60 * 1000) % 60; // minutes
            diffHours = diff / (60 * 60 * 1000) % 24; // hours
            // creates a time string with the format ##/##/##
            runtime = df.format(diffHours)+":"+df.format(diffMinutes)+":"+df.format(diffSeconds);
        } catch (Exception ex) {
            
        }
        return runtime;
    }

}
