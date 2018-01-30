package util;

import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.Workbook;   //workbook is an abstract class with no static
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;

import java.io.File;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import model.HotelAvailability;
import model.HotelName;
import model.RoomAvailability;


/**
 * Created by Chloe on 8/22/2017.
 */
public class ExcelWriter {

	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/resources/ExcelOutput/";
	private static final int DATE_STARTING_COLUMN = 3;  //arbitrary; very first column is 3

    public static void writeHotelAvailability(HotelAvailability hotelAvailability) throws Exception {
    	
        HotelName hotelName = hotelAvailability.getName();
        String folderPath = EXCEL_FILE_PATH + hotelName.getResortName().getDisplayName();
        ensureOutputDirectoryExists(folderPath);

        String filePath = folderPath + "/" + hotelName.getDisplayName() + ".xls";

        Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();
        Calendar earliestDate = hotelAvailability.getEarliestKnownDate();
        Calendar latestDate = hotelAvailability.getLatestKnownDate();

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        try {
            myFirstWbook = Workbook.createWorkbook(new File(filePath));

            // create an Excel sheet
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

            // add the title into the sheet
            Label property = new Label(0, 0, hotelAvailability.getName().getDisplayName());
            excelSheet.addCell(property);
            writeAllDateLabels(excelSheet, earliestDate, latestDate);
            //cycle through each room by unit number in the map of all rooms, update each of their availability in excel sheet under corresponding date

            writeAvailabilityForAllRooms(excelSheet, roomAvailabilities, earliestDate, latestDate);

            myFirstWbook.write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	myFirstWbook.close();
        }

    }


    //add the month names and dates into the top of the sheet
    private static void writeAllDateLabels(WritableSheet excelSheet, Calendar startDate, Calendar endDate) throws RowsExceededException, WriteException {
    	//Calendar now = Calendar.getInstance();  //also set time zone to GMT?    keep for Cirrus     
    	YearMonth startingYearMonth = YearMonth.of(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH) + 1);
        YearMonth finalYearMonth = YearMonth.of(endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH) + 1);
    	int startingDayOfMonth = startDate.get(Calendar.DAY_OF_MONTH);

    	int monthStartingColumn = DATE_STARTING_COLUMN;
    	for (YearMonth ym = startingYearMonth; !ym.isAfter(finalYearMonth); ym = ym.plusMonths(1)) {
    		int endingDayOfMonth = ym.equals(DateUtils.getYearMonthFromDate(endDate)) ? endDate.get(Calendar.DAY_OF_MONTH) : ym.lengthOfMonth();
    		writeDateLabelsForMonth(excelSheet, ym, monthStartingColumn, startingDayOfMonth, endingDayOfMonth);
    		monthStartingColumn = monthStartingColumn + (ym.lengthOfMonth() - startingDayOfMonth + 1);
    		startingDayOfMonth = 1;
    	}
    }

    //add the dates into the top of the sheet for a given month
    private static void writeDateLabelsForMonth(WritableSheet excelSheet, YearMonth yearMonth, int startingColumn,
    		int startingDayOfMonth, int endingDayOfMonth) throws RowsExceededException, WriteException {

        Label month = new Label(startingColumn, 0 , yearMonth.getMonth().toString() + " " + yearMonth.getYear());
        excelSheet.addCell(month);
        int remainingDaysInMonth = endingDayOfMonth - startingDayOfMonth;
        excelSheet.mergeCells(startingColumn, 0, startingColumn + remainingDaysInMonth - 1, 0);

        int columnCounter = 1;
        for(int i=startingDayOfMonth; i <= endingDayOfMonth; i++) {
        	Number dateInMonth = createCenteredCellNumber(startingColumn -1 + columnCounter, 1, i);
            excelSheet.addCell(dateInMonth);
            columnCounter++;
        }
    }

    private static void writeAvailabilityForAllRooms(WritableSheet excelSheet, Map<String, RoomAvailability> roomAvailabilities,
    		Calendar earliestDate, Calendar latestDate) throws RowsExceededException, WriteException {
        int row = DATE_STARTING_COLUMN;
        for (Entry<String, RoomAvailability> entry : roomAvailabilities.entrySet()){  //for all unit numbers (rooms) in the map
            String currentroomnumber = entry.getKey();
            Label propertynum = new Label(1, row, currentroomnumber);
            excelSheet.addCell(propertynum);
            writeAvailabilityForRoom(excelSheet, entry.getValue(), row, earliestDate, latestDate);
            row++;
        }
    }

    private static void writeAvailabilityForRoom(WritableSheet excelSheet, RoomAvailability currentRoomAvailability, int row,
    		Calendar startDate, Calendar endDate) throws RowsExceededException, WriteException {
    	int currentColumn = DATE_STARTING_COLUMN;

        for (Calendar date : DateUtils.getOrderedDateRange(startDate, endDate)) {
        	Map<Calendar, Optional<Boolean>> totalAvailability = currentRoomAvailability.getTotalAvailability();
            Optional<Boolean> isAvailable = totalAvailability.get(date);
            if (isAvailable == null) {
                throw new RuntimeException("Error when writing to the excel sheet: "
                		+ "a null value was returned for date " + DateUtils.getReadableDateString(date) + 
                		" for room " + currentRoomAvailability.getRoomNumber());
            }
            Label availabilityContent = createCenteredCellLabel(currentColumn, row, Symbols.getDisplaySymbol(isAvailable));

            excelSheet.addCell(availabilityContent);
            currentColumn++;
        }
    }

    private static Label createCenteredCellLabel(int column, int row, String content) throws WriteException {
    	Label availabilityContent = new Label(column, row, content);
    	centerCell(availabilityContent);
		return availabilityContent;
    }

    private static Number createCenteredCellNumber(int column, int row, int content) throws WriteException {
    	Number number = new Number(column, row, content);
    	centerCell(number);
		return number;
    }

    private static void centerCell(WritableCell cell) throws WriteException {
    	CellFormat readFormat = cell.getCellFormat();
		WritableCellFormat newFormat = new WritableCellFormat(readFormat);
		newFormat.setAlignment(Alignment.CENTRE);
		cell.setCellFormat(newFormat);
    }

    private static void ensureOutputDirectoryExists(String folderPath) {
        File outputFolder = new File(folderPath);
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
    }
}

