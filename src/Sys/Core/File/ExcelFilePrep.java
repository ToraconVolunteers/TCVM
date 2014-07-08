package Sys.Core.File;

/**
 * 
 * @author TheHoudhini
 * @date Oct 10, 2013
 */
public class ExcelFilePrep {
    
    private static String fileAddress;
    // The following integers corresond to the column number of each field in the spreadsheet
    private static int nameCol = 0; // full name (i.e. First Middle Last)
    //private static int firstNameCol = 0; // first name
    //private static int lastNameCol = 1; // last name
    //private static int genderCol = 2; // gender
    private static int emailCol = 1; // email address
    //private static int mobileCol = 4; // mobile phone number
    private static int mobileCol = 3; // mobile phone number
    //private static int memberCol = 5; // membership status 
    //private static int preregCol = 6; // pre-registration status
    //private static int pastCon = 7; // past con experience
    private static int pastConCol = 10; // past con experience
    //private static int shirtSize = 8; //T-Shirt size
    private static int shirtSizeCol = 5; //T-Shirt size
    //private static int availabilityCol = 9;
    //private static int targetTimeCol = 10;
    private static int scheduleCol = 13;
    private static int timeDay1Col = 6;
    private static int timeDay2Col = 7;
    private static int fridayAvailabilityCol = 8;
    private static int disabilityCol = 9;
    //private static int noteCol = 11;
    private static int noteCol = 11;
    //private static int completedCol = 12;
    private static int completedCol = 14;
    //private static int reimbursmentCol = 13;
    private static int reimbursmentCol = 15;
    //private static int statusCol = 14;
    private static int statusCol = 16;
    //private static int feedbackCol = 15;
    private static int feedbackCol = 17;
    private static int lastUserInfoCol = 18; // column after last column
    
    public void setFileAddress(String newFileAddress) {
        fileAddress = newFileAddress;
    }
    
    public static String getFileAddress() {
        // sets a permanent file address
        fileAddress = "T:\\Users\\TheHoudhini\\Dropbox\\Java\\NetBeansProjects\\TCVM\\src\\Resources\\Volunteers 2014.xls";
        //fileAddress = "T:\\Users\\TheHoudhini\\Dropbox\\Java\\NetBeansProjects\\TCVM\\src\\Resources\\Test.xls";
        return fileAddress;
    }
    
    
    public static int getNameCol() {
        return nameCol;
    }
    
    /*
    public static int getFirstNameCol() {
        return firstNameCol;
    }
    
    public static int getLastNameCol() {
        return lastNameCol;
    }
    */
    
    public static int getEmailCol() {
        return emailCol;
    }    

    public static int getMobileCol() {
        return mobileCol;
    }
    
    public static int getPastConCol() {
        return pastConCol;
    }    

    public static int getShirtSizeCol() {
        return shirtSizeCol;
    }    

    public static int getTimeDay1Col() {
        return timeDay1Col;
    }    

    public static int getTimeDay2Col() {
        return timeDay2Col;
    }    

    public static int getFridayAvailabilityCol() {
        return fridayAvailabilityCol;
    }    

    public static int getDisabilityCol() {
        return disabilityCol;
    }    

    public static int getNoteCol() {
        return noteCol;
    }
        

    public static int getCompletedCol() {
        return completedCol;
    }    

    public static int getReimbursementCol() {
        return reimbursmentCol;
    }
    
    public static int getStatusCol() {
        return statusCol;
    }
    
     public static int getScheduleCol() {
        return scheduleCol;
    }
     
    public static int getFeedbackCol() {
        return feedbackCol;
    }
    
    public static int getLastUserInfoCol() {
        return lastUserInfoCol;
    }
}
