package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Navigate to foneloan portal
		driver.get("http://qa2-bank.foneloan.com.np/#/login");
		driver.manage().window().maximize();

		File src = new File("C:\\Users\\F1soft\\eclipse-workspace\\FoneloanAutomation\\excelfile\\data.xlsx"); //Load excel file
		FileInputStream fis = new FileInputStream(src);      //Convert the file into bytes
		XSSFWorkbook wb = new XSSFWorkbook(fis);             //Load complete excel file
		XSSFSheet sheet1 = wb.getSheetAt(0);				//Load specific sheet as per need
		
		
		int totalRows = sheet1.getPhysicalNumberOfRows();            //Get total number of rows
		System.out.println(totalRows);
		Row rowCells = sheet1.getRow(0);
		int totalCols = rowCells.getLastCellNum();		   //Get total number of columns
		System.out.println(totalCols);
		Thread.sleep(2000);

		for (int i = 1; i < totalRows; i++) {              //Loop to get data from excel file

		String username = sheet1.getRow(i).getCell(0).getStringCellValue();
		String password = sheet1.getRow(i).getCell(1).getStringCellValue();

		System.out.println(username);                     //print username and password in console
		System.out.println(password);

		driver.findElement(By.id("username")).sendKeys(username);            
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/div/form/div/div[2]/button")).click();
		Thread.sleep(3000);

		// Logout
		driver.findElement(By.id("dropdownMenuButtonUser")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//app-header-drop-down/div[1]/div[1]/div[1]/div[1]/a[4]")).click();
		Thread.sleep(3000);
			
		// wb.close();

		}
	}

}
