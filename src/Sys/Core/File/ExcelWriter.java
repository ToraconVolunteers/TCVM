/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Core.File;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import jxl.write.WritableCell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author TheHoudhini
 * @date 09 Oct, 2013
 */
public class ExcelWriter {
    private static String fileAddress = Sys.Core.File.ExcelFilePrep.getFileAddress();
    
    public static void writeNumber(int value, int col, int row) throws IOException, WriteException {
        File outputFile = new File(fileAddress);
        try {
            Workbook existingWorkbook = Workbook.getWorkbook(outputFile);
            WritableWorkbook bufferWorkbook = Workbook.createWorkbook(new File(fileAddress), existingWorkbook);
            WritableSheet sheetToEdit = bufferWorkbook.getSheet(0);
            WritableCell cell;
            Number number = new Number(col, row, value);
            cell = (WritableCell) number;
            sheetToEdit.addCell(cell);
            bufferWorkbook.write();
            bufferWorkbook.close();
            existingWorkbook.close();
            Sys.Core.Util.Logger.incrementWriteCount();
        } catch (Exception ex) {
            Sys.Core.Util.Logger.appendLog(Sys.Core.Util.DateAndTime.getDateAndTime()+" - Error: Write to spreadsheet fail");
            //JOptionPane.showMessageDialog(null, "Number could not be written to the excel file. \nThe following error occured:" + ex, "Error: Write Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void writeText(String text, int col, int row) throws IOException, WriteException {
        File outputFile = new File(fileAddress);
        try {
            Workbook existingWorkbook = Workbook.getWorkbook(outputFile);
            WritableWorkbook bufferWorkbook = Workbook.createWorkbook(new File(fileAddress), existingWorkbook);
            WritableSheet sheetToEdit = bufferWorkbook.getSheet(0);
            WritableCell cell;
            Label label = new Label(col, row, text);
            cell = (WritableCell) label;
            sheetToEdit.addCell(cell);
            bufferWorkbook.write();
            bufferWorkbook.close();
            existingWorkbook.close();
            Sys.Core.Util.Logger.incrementWriteCount();
        } catch (Exception ex) {
            Sys.Core.Util.Logger.appendLog(Sys.Core.Util.DateAndTime.getDateAndTime()+" - Error: Write to spreadsheet fail");
            //JOptionPane.showMessageDialog(null, "Text could not be written to the excel file. \nThe following error occured:" + ex, "Error: Write Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void statusToggle(int binary, int row) {
        try {
            if (binary == 0) {
                // Set status as inactive
                writeText("inactive", ExcelFilePrep.getStatusCol(), row);
            } else if (binary == 1) {
                // Set status as active
                writeText("active", ExcelFilePrep.getStatusCol(), row);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "Could not toggle status. \nThe following error occured:" + ex, "Error: Status Toggle Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void incrementHoursCompleted(float increment, int row) {
        float totalCompletedHours, completedHours;
        completedHours = Float.parseFloat(Sys.Core.File.ExcelReader.getCellContent(ExcelFilePrep.getCompletedCol(), row));
        // calculates the new total completed hours
        totalCompletedHours = completedHours + increment;
        // converts the total completed hours to two decimal places
        DecimalFormat df = new DecimalFormat("##.##");
        String totalCompletedHoursInFormat = df.format(totalCompletedHours);
        try {
            // writes the updated completed hours to excel file (col 12)
            writeText(totalCompletedHoursInFormat, ExcelFilePrep.getCompletedCol(), row);
        } catch (Exception ex) {
            
        }
    }
    
    public static void reimbursement(int row) {
        float completedHours = Float.parseFloat(Sys.Core.File.ExcelReader.getCellContent(ExcelFilePrep.getCompletedCol(), row));
        try {
            if (completedHours >= 4.0) {
                writeText("Yes", ExcelFilePrep.getReimbursementCol(), row);
            }
        } catch (Exception ex) {
            
        }
    }
        
}
