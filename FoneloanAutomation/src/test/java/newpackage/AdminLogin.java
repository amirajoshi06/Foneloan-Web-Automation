package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdminLogin {

	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Browserdrivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		//Valid login
		driver.get("http://qa2-bank.foneloan.com.np/#/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("amira.joshi@f1soft.com");
		driver.findElement(By.id("password")).sendKeys("amira@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/div/form/div/div[2]/button")).click();
		Thread.sleep(5000);
		
		
		//Assertion
		String expectedtitle ="Loan Overview";
		String actualtitle= driver.findElement(By.xpath("//span[contains(text(),'Loan Overview')]")).getText();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Test Passed");
		Thread.sleep(2000);
		
		
		//User logout
		 driver.findElement(By.id("dropdownMenuButtonUser")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//app-header-drop-down/div[1]/div[1]/div[1]/div[1]/a[4]")).click();
		 Thread.sleep(3000);
		
		 
		//Invalid username invalid password
		driver.findElement(By.id("username")).sendKeys("amira.joshi@f1soft.com");
		driver.findElement(By.id("password")).sendKeys("@@@@123**");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div[2]/div/form/div/div[2]/button")).click();
		
		//Assertion
		String expectedvalue = "Log in";
		String actualvalue = driver.findElement(By.xpath("//h1[contains(text(),'Log in')]")).getText();
		Assert.assertEquals(actualvalue, expectedvalue);
		System.out.println("Logout Successfully");
		Thread.sleep(5000);
		
		//Close browser
		driver.quit();
		
		
		
	}

}
