package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
		workbook = new XSSFWorkbook("C:\\Users\\F1soft\\eclipse-workspace\\FoneloanAutomation\\excelfile\\data.xlsx");
		sheet = workbook.getSheet("Sheet1");
	}
	catch(Exception exp) {
		System.out.println(exp.getCause());
		exp.printStackTrace();
	}
	}
	public static void main(String[] args) {
		//getRowCount(0,0);
		getCellData(1,1);
	}
	public static void getRowCount() {

		//Create references for workbook
		try {


			

			//Get number of rows
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows : "+rowCount);

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	//Create references for worksheet
	public static void getCellData(int rownum, int colnum) {
		try {
			workbook = new XSSFWorkbook("C:\\Users\\F1soft\\eclipse-workspace\\FoneloanAutomation\\excelfile\\data.xlsx");
			sheet = workbook.getSheet("Sheet1");
			String cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			System.out.println(cellData);                   
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();

		}}
	
	
}
