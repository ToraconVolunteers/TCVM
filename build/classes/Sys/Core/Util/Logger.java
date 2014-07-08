/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sys.Core.Util;

import java.util.ArrayList;

/**
 * 
 * @author TheHoudhini
 * @date Nov 4, 2013
 */
public class Logger {
    static ArrayList<String> logArrayList = new ArrayList<>();
    private static int errorCount, readCount, writeCount, checkInCount, checkOutCount, totalVolunteerCount;
    
    public static void appendLog(String append) {
        logArrayList.add(append);
    }
    
    public static String[] getLog() {
        String[] log = new String[logArrayList.size()];
        log = logArrayList.toArray(log);
        return log;
    }
    
    // increments the write count (for File IO statistic)
    public static void incrementReadCount() {
        readCount++;
    }
    
    // gets the read count
    public static int getReadCount() {
        return readCount;
    }
    
    // increments the write count (for File IO statistic)
    public static void incrementWriteCount() {
        writeCount++;
    }
    
    // gets the write count
    public static int getWriteCount() {
        return writeCount;
    }
    
    // increments the error count (for system error statistic)
    public static void incrementErrorCount() {
        errorCount++;
    }
    
    // gets the error count
    public static int getErrorCount() {
        return errorCount;
    }

    public static void incrementCheckInCount() {
        checkInCount++;
    }
    
    public static int getCheckInCount() {
        return checkInCount;
    }
    
    public static void incrementCheckOutCount() {
        checkOutCount++;
    }
    
    public static int getCheckOutCount() {
        return checkOutCount;
    }
    
    public static void setTotalVolunteerCount(int count) {
        totalVolunteerCount = count;
    }
    
    public static int getTotalVolunteerCount() {
        return totalVolunteerCount;
    }
}
