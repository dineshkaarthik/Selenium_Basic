package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class XpathAssignment2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Enter user name
		WebElement eleUserName = driver.findElementByXPath("//input[@id='username']");
		eleUserName.sendKeys("DemoSalesManager");
				
		//Enter password
		WebElement elePassword = driver.findElementByXPath("//input[@id='password']");
		elePassword.sendKeys("crmsfa");
				
		//Click on the Login
		WebElement eleSubmit = driver.findElementByXPath("//input[@value='Login']");
		eleSubmit.click();
				
		//Click on the CRM/SFA link
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		//Click on the Leads tab
		driver.findElementByXPath("//a[text()='Leads']").click();
				
		//Click on the Find Leads link
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Click the Phone tab
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		//Enter phone number
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("9876");
		
		//Click on the Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Get the Lead ID
		String LeadID = driver.findElementByXPath("(//div[@class='x-grid3-row   '])[1]/following::a[1]").getText();
		System.out.println(LeadID);
		
		//Click on the first record
		driver.findElementByXPath("(//div[@class='x-grid3-row   '])[1]/following::a[1]").click();
		
		Thread.sleep(4000);
		//Click on the Delete button
		driver.findElementByXPath("//a[text()='Delete']").click();
		
		Thread.sleep(4000);
		//Click on the Find Leads link
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//Enter the Lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(LeadID, Keys.TAB);
		
		//Click on the Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Read the expected message: No records to display
		String expMsg = driver.findElementByXPath("//div[text()='No records to display']").getText();
		
		System.out.println(expMsg);
		
		//Validate the message is displayed and record is deleted successfully
		if (expMsg.contains("No records to display")) {
			
			System.out.println("Lead record deleted successfully");
			
		} else {
			
			System.out.println("Lead record is not deleted");

		}
		
		//Close the browser
		driver.close();
		
	}

}
