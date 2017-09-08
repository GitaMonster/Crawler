package util;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelWriter {

	private static final String EXCEL_FILE_LOCATION = "/Users/adrian.bocker/Desktop/Crawling/excelOutput/test.xlsx";

	public static void main(String[] args) {
		writeToExcel();
	}

	public static void writeToExcel() {

		//1. Create an Excel file
		WritableWorkbook myFirstWbook = null;
		try {

			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

			// create an Excel sheet
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

			// add something into the Excel sheet
			Label label = new Label(0, 0, "Test Count");
			excelSheet.addCell(label);

			Number number = new Number(0, 1, 1);
			excelSheet.addCell(number);

			label = new Label(1, 0, "Result");
			excelSheet.addCell(label);

			label = new Label(1, 1, "Passed");
			excelSheet.addCell(label);

			number = new Number(0, 2, 2);
			excelSheet.addCell(number);

			label = new Label(1, 2, "Passed 2");
			excelSheet.addCell(label);

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

}
