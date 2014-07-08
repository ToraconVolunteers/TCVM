/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Core.Util;

import Sys.UI.LogUI;
import Sys.UI.MainUI;
import java.util.TimerTask;

/**
 *
 * @author Shehan
 * @date Feb 5, 2014
 */
public class ScheduledTask extends TimerTask {
    
    public void run() {
        MainUI.setDateTimeLabel(DateAndTime.getDateAndTime());
        LogUI.runtime();
    }
}
