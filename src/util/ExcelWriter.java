package util;

import jxl.Workbook;   //workbook is an abstract class with no static
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.HotelAvailability;
import model.RoomAvailability;


/**
 * Created by Chloe on 8/22/2017.
 */
public class ExcelWriter {

	private static final String EXCEL_FILE_PATH = System.getProperty("user.home") + "/Desktop/Crawling/ExcelOutput/";

    public static void main(HotelAvailability hotelAvailability) throws Exception {
    	
    	String hotelName = hotelAvailability.getName().getDisplayName();
//    	String EXCEL_FILE_LOCATION = System.getProperty("user.home") + "/Desktop/Crawling/ExcelOutput/" + hotelName + ".xls";
    	String filePath = EXCEL_FILE_PATH + hotelName + ".xls";

        Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(filePath));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add the title into the sheet
            Label property = new Label(0, 0, hotelAvailability.getName().toString());
            excelSheet.addCell(property);
            writeAllDateLabels(excelSheet, hotelAvailability.getEarliestKnownDate(), hotelAvailability.getLatestKnownDate());
            //cycle through each room by unit number in the map of all rooms, update each of their availability in excel sheet under corresponding date

//            int row = 3;
//            for (Entry<String, RoomAvailability> entry : roomAvailabilities.entrySet()){  //for all unit numbers (rooms) in the map
//                String currentroomnumber = entry.getKey();
//                Label propertynum = new Label(1, row, currentroomnumber);
//                excelSheet.addCell(propertynum);
//                writeAvailabilityForRoom(excelSheet, entry.getValue(), row, hotelAvailability.getEarliestKnownDate(), hotelAvailability.getLatestKnownDate());
//                row++;
//            }

            myFirstWbook.write();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //add the month names and dates into the top of the sheet
    private static void writeAllDateLabels(WritableSheet excelSheet, Calendar startDate, Calendar endDate)throws Exception{
    	//Calendar now = Calendar.getInstance();  //also set time zone to GMT?    keep for Cirrus     
    	//int startingDateInStartingMonth = now.get(Calendar.DATE);                             
    	//YearMonth startingYearMonth = YearMonth.now();                         
    	int startingDayOfMonth = startDate.get(Calendar.DAY_OF_MONTH);
    	YearMonth startingYearMonth = YearMonth.of(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH)+1);
        YearMonth finalYearMonth = YearMonth.of(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH)+1);
    	
    	int monthStartingColumn = 3; //arbitrary; very first column is 3
    	for(YearMonth ym = startingYearMonth; !ym.equals(finalYearMonth.plusMonths(1)); ym = ym.plusMonths(1)) {
    		writeDateLabelsForMonth(excelSheet, ym, monthStartingColumn, startingDayOfMonth);
    		startingDayOfMonth = 1;
    		monthStartingColumn = monthStartingColumn + (ym.lengthOfMonth()-startingDayOfMonth);
    	}
    }

    //add the dates into the top of the sheet for a given month
    private static void writeDateLabelsForMonth(WritableSheet excelSheet, YearMonth yearMonth, int startingColumn, int startingDayOfMonth) throws Exception{

        Label month = new Label(startingColumn, 0 , yearMonth.getMonth().toString() + " " + yearMonth.getYear());
        excelSheet.addCell(month);
        int remainingDaysInMonth = yearMonth.lengthOfMonth() - startingDayOfMonth;
        excelSheet.mergeCells(startingColumn, 0, startingColumn + remainingDaysInMonth - 1, 0);

        int columnCounter = 1;
        for(int i=startingDayOfMonth; i <= yearMonth.lengthOfMonth(); i++) {
            Number dateInMonth = new Number(startingColumn -1 + columnCounter, 1, i);
            excelSheet.addCell(dateInMonth);
            columnCounter++;
        }
    }

    //COMBINE THE NEXT 2 METHODS INTO 1
    private static void writeAvailabilityForRoom(WritableSheet excelSheet, RoomAvailability currentRoomAvailability, int row, Calendar startDate, Calendar endDate) throws Exception{

    	//ALL ADDED:
    	int firstDayOfEachMonth = startDate.get(Calendar.DATE);   //starting day
        YearMonth startingYearMonth = YearMonth.of(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH));
        YearMonth finalYearMonth = YearMonth.of(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH));
        int startingColumn = 3;
       
        for(YearMonth currentYearMonth = startingYearMonth; !currentYearMonth.equals(finalYearMonth.plusMonths(1)); currentYearMonth = currentYearMonth.plusMonths(1)) {
            writeAvailabilityForMonth(excelSheet, currentRoomAvailability, row, startingColumn, currentYearMonth, firstDayOfEachMonth);
            startingColumn = startingColumn + currentYearMonth.lengthOfMonth();
            firstDayOfEachMonth = 1;
        }
    }

    private static void writeAvailabilityForMonth(WritableSheet excelSheet, RoomAvailability currentRoomAvailability,
    		int row, int startingColumn, YearMonth yearMonth, int startingDayOfMonth) throws RowsExceededException, WriteException {

        int daysInMonth = yearMonth.lengthOfMonth();
        int startingYear = yearMonth.getYear();
        for(int i=startingDayOfMonth ; i<=daysInMonth ; i++) {

            Calendar date = new GregorianCalendar(startingYear, yearMonth.getMonth().getValue()-1, i);  //yearMonth uses 1-12 while Gregorian calendar runs 0-11

            Map<Calendar, Optional<Boolean>> totalAvailability = currentRoomAvailability.getTotalAvailability();
            Optional<Boolean> isAvailable = totalAvailability.get(date);
            if (isAvailable == null) {
                throw new RuntimeException("Error when writing to the excel sheet: "
                		+ "a null value was returned for date " + DateUtils.getReadableDateString(date));
            }
            String cellContent;
            if (isAvailable.isPresent()) {
            	cellContent = isAvailable.get() ? "Y" : "X";
            } else {
            	cellContent = " ";
            }
            Label dateavail = new Label(startingColumn -1 + i, row, cellContent);
            excelSheet.addCell(dateavail);

        }
    }
}

