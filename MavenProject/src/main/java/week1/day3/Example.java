package week1.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClassAssignment {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch the applicaion
		driver.get("https://acme-test.uipath.com/account/login");
		
		//Enter user name
		WebElement eleUserName = driver.findElementById("email");
		eleUserName.sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		
		//Enter password
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys("leaf@12");
		
		
		//Click on the Log in button
		WebElement eleSubmit = driver.findElementById("buttonLogin");
		eleSubmit.click();
		
		//Thread.sleep(2000);
		
		//Mouse over on the Vendor button
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		
		//Click the vendor search
		driver.findElementByLinkText("Search for Vendor").click();
		//Thread.sleep(1000);
		
		//Enter the vendor name
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		//Click on the search button
		driver.findElementById("buttonSearch").click();
		//Thread.sleep(1000);
		
		//Read the country name
		String countryName = driver.findElementByXPath("(//table[@class='table']//td)[5]").getText();
		System.out.println(countryName);
		
		//Click on the logout
		driver.findElementByLinkText("Log Out").click();
		
		//close the application
		driver.close();
		
	}

}
