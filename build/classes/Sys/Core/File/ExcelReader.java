/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Core.File;

import java.io.File;
import java.util.ArrayList;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
/**
 *
 * @author TheHoudhini
 * @date 09 Oct, 2013
 */
public class ExcelReader {
    
    private static String fileAddress = Sys.Core.File.ExcelFilePrep.getFileAddress();
    
    // returns the contents of a particula cell in the spreadsheet
    public static String getCellContent(int col, int row) {
        File inputWorkbook = new File(fileAddress);
        Workbook workBook;
        String cellContent = null;
        try {
            workBook = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = workBook.getSheet(0);
            Cell cell = sheet.getCell(col, row);
            cellContent = cell.getContents();
            Sys.Core.Util.Logger.incrementReadCount();
        } catch(Exception ex) {
            System.out.println(ex);
        }
        return cellContent;
    }
    
    // returns an array of strings holding the contents of an entire column
    public static String[] getColContent(int col) {
        ArrayList<String> colContentArrayList = new ArrayList<>();
        File inputWorkbook = new File(fileAddress);
        Workbook workBook;
        try {
            workBook = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = workBook.getSheet(0);
                for (int i = 1; i < sheet.getRows(); i++) {
                  Cell cell = sheet.getCell(col, i);
                  colContentArrayList.add(cell.getContents());
                }
            Sys.Core.Util.Logger.incrementReadCount();    
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        String[] colContent = new String[colContentArrayList.size()];
        colContent = colContentArrayList.toArray(colContent);
//        }
        return colContent;
    }
    
    // returns an array of strings holding the contents of an entire row
    public static String[] getRowContent(int row) {
        ArrayList<String> rowContentArrayList = new ArrayList<>();
        File inputWorkbook = new File(fileAddress);
        Workbook workBook;
        try {
            workBook = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = workBook.getSheet(0);
                for (int i = 0; i < sheet.getColumns(); i++) {
                  Cell cell = sheet.getCell(i, row);
                  rowContentArrayList.add(cell.getContents());
                }
            Sys.Core.Util.Logger.incrementReadCount();    
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        String[] rowContent = new String[rowContentArrayList.size()];
        rowContent = rowContentArrayList.toArray(rowContent);
//        }
        return rowContent;
    }
    
    // returns the row number where the selection string is located in a specified column
    public static int getRow(String selection, int col) {
        String[] list = getColContent(col);
        int row = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(selection)) {
                row = i + 1;
                break;
            }
        }
        return row;
    }
    
    // returns the column number where the selection string is located in a specified row
    public static int getCol(int row, String selection) {
        String[] list = getRowContent(row);
        int col = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(selection)) {
                col = i + 1;
                break;
            }
        }
        return col;
    }
    
    // returns a specific column number, ie. first, last, next-empty column of a specified row
    public static int getSpecificCol(int row, String location) {
        String[] list = getRowContent(row);
        int col = -1;
        int i = 0;
        switch (location) {
            // first column (i.e. col 0)
            case "first": {
                col = 0;
                break;
            }
            // middle column (i.e. total_col_number/2)
            case "middle": {
                col = list.length/2;
                break;
            }
            // first empty column
            case "first_empty": {
                while (i < list.length) {
                    if (list[i].isEmpty()) {
                        col = i - 1;
                        break;
                    } else if (i == (list.length - 1)) {
                        col = i;
                        break;
                    } else {
                        i++;
                    }
                }
                break;
            }
            // last column
            case "last": {
                while (i < list.length) {
                    if (list[i].isEmpty() && list[i+1].isEmpty() && list[i+2].isEmpty()) {
                        col = i - 1;
                        break;
                    } else if (i == (list.length - 3)) {
                        for (int j = i; j <= list.length; j++) {
                            if (j == list.length) {
                                col = j - 1;
                                break;
                            } else if (list[j].isEmpty()) {
                                col = j - 1;
                                break;
                            }
                        }
                        break;
                    } else {
                        i++;
                    }
                }
                break;
            }
            // first empty column
            case "next_empty": {
                col = getSpecificCol(row, "last") + 1;    
                break;
            }
        }
        return col;
    }
    
    // returns the starting timestamp or location+description of the currently active shift
    public static String getShiftStartDetail(int col, int row, String info) {
        StringBuilder shiftLocationAndDescription = new StringBuilder();
        String shiftDetail = getCellContent(col, row);
        String[] split = shiftDetail.split(" ");
        String detail = "error";
        if (split[0].equals("in")) {
            switch (info) {
                case "timestamp":
                    detail = split[4];
                    break;
                case "loc_des":
                    for (int i = 6; i < split.length; i++) {
                        shiftLocationAndDescription.append(split[i]);
                        shiftLocationAndDescription.append(" ");
                    }
                    detail = shiftLocationAndDescription.toString();
                    break;
            }
        }
        return detail;
    }
    
    // returns the number of active or inactive volunteers (argument must either be "active" or "inactive")
    public static int getStatusCount(String status) {
        String[] statusColContent = getColContent(ExcelFilePrep.getStatusCol());
        int count = 0;
        switch (status) {
            case "active":
                for (int i = 0; i < statusColContent.length; i++) {
                    if (statusColContent[i].equals("active")) {
                        count++;
                    }
                }
                break;
            case "inactive":
                for (int i = 0; i < statusColContent.length; i++) {
                    if (statusColContent[i].equals("inactive")) {
                        count++;
                    }
                }
                break;
        }
        return count;
    }
}
