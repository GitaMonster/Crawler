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

import jxl.write.Number;
import jxl.write.WriteException;
import model.HotelAvailability;
import model.RoomAvailability;


/**
 * Created by Chloe on 8/22/2017.
 */
public class ExcelWriter {

    private static final String EXCEL_FILE_LOCATION = "C:/Users/Chloe/Desktop/Crawling/ExcelOutput/BWA.xls";

    public static void main(HotelAvailability availability) throws Exception {

        Map<String, RoomAvailability> roomAvailabilities = availability.getRoomAvailabilities();

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {

            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add the title into the sheet
            Label property = new Label(0, 0, availability.getName().toString());
            excelSheet.addCell(property);
            writeAllDateLabels(excelSheet);
            //cycle through each room by unit number in the map of all rooms, update each of their availability in excel sheet under corresponding date

            int row = 3;
            for (Entry<String, RoomAvailability> entry : roomAvailabilities.entrySet()){  //for all unit numbers (rooms) in the map
                String currentroomnumber = entry.getKey();
                Label propertynum = new Label(1, row, currentroomnumber);
                excelSheet.addCell(propertynum);
                writeAvailabilityForRoom(excelSheet, entry.getValue(), row);
                row++;
            }

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
    private static void writeAllDateLabels(WritableSheet excelSheet)throws Exception{
        YearMonth Dec2017 = YearMonth.of(2017, 12);
        YearMonth Jan2018 = YearMonth.of(2018, 1);
        YearMonth Feb2018 = YearMonth.of(2018, 2);

        writeDateLabels(excelSheet, Dec2017, 3);     //3 is the arbitrary starting column
        writeDateLabels(excelSheet, YearMonth.of(2018, 1), 3 + Dec2017.lengthOfMonth());
        writeDateLabels(excelSheet, YearMonth.of(2018, 2), 3 + Jan2018.lengthOfMonth() + Dec2017.lengthOfMonth());
        writeDateLabels(excelSheet, YearMonth.of(2018, 3), 3 + Feb2018.lengthOfMonth() + Jan2018.lengthOfMonth() + Dec2017.lengthOfMonth());

    }

    //add the dates into the top of the sheet for a given month
    private static void writeDateLabels(WritableSheet excelSheet, YearMonth yearMonth, int startingColumn) throws Exception{

        Label month = new Label(startingColumn, 0 , yearMonth.getMonth().toString() + " " + yearMonth.getYear());
        excelSheet.addCell(month);
        excelSheet.mergeCells(startingColumn, 0, startingColumn + yearMonth.lengthOfMonth() - 1, 0);

        for(int i=1; i <= yearMonth.lengthOfMonth(); i++) {
            Number dateInMonth = new Number(startingColumn -1 + i, 1, i);
            excelSheet.addCell(dateInMonth);
        }
    }

    //for each month, write availability for room
    private static void writeAvailabilityForRoom(WritableSheet excelSheet, RoomAvailability currentRoomAvailability, int row) throws Exception{

        YearMonth startingMonth = YearMonth.of(2017, 12);  //starting month
        int startingColumn = 3;

        for(YearMonth currentYearMonth = startingMonth; !currentYearMonth.equals(YearMonth.of(2018, 04)) ; currentYearMonth = currentYearMonth.plusMonths(1)) {

            writeAvailabilityForMonth(excelSheet, currentRoomAvailability, row, startingColumn, currentYearMonth);

            startingColumn = startingColumn + currentYearMonth.lengthOfMonth();
        }

    }

    private static void writeAvailabilityForMonth(WritableSheet excelSheet, RoomAvailability currentRoomAvailability, int row, int startingColumn, YearMonth yearMonth)throws Exception {

        int daysInMonth = yearMonth.lengthOfMonth();
        int startingYear = yearMonth.getYear();
        for(int i=1 ; i<=daysInMonth ; i++) {

            Calendar date = new GregorianCalendar(startingYear, yearMonth.getMonth().getValue()-1, i);  //yearMonth uses 1-12 while gregorian calendar runs 0-11

            Map<Calendar, Boolean> totalAvailability = currentRoomAvailability.getTotalAvailability();
            Boolean availBoolean = totalAvailability.get(date);
            if (availBoolean == null) {
                System.out.println("hi");
            }
            Label dateavail = new Label(startingColumn -1 + i, row, availBoolean ? "Y" : "X");
            excelSheet.addCell(dateavail);

        }
    }
}

