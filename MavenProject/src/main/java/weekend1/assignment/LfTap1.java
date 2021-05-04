package weekend1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WeekendAssignment1 {

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
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("DemoSalesManager");
		
		//Enter password
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys("crmsfa");
		
		//Click on the Login
		WebElement eleSubmit = driver.findElementByClassName("decorativeSubmit");
		eleSubmit.click();
		
		//Click on the CRM/SFA link
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click on the Leads tab
		driver.findElementByLinkText("Leads").click();
		
		//Click on the Find Leads link
		driver.findElementByLinkText("Find Leads").click();
		
		//Enter the FirstName
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Test",Keys.TAB);
		
		//Click on the Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		
		//Click on the first result displayed
		driver.findElementByXPath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[3]/div[1]/a[1]").click();
		
		//Get the title of the page
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		//Verify the titleis displayed correctly
		if (pageTitle.contains("View Lead | opentaps CRM")) {
			
			System.out.println("Page Title displayed correctly");
			
		} else {
			System.out.println("Page Title did not display correctly");

		}
		
		//Click on the Edit button
		driver.findElementByLinkText("Edit").click();
		
		Thread.sleep(4000);
		
		//Create a string variable and assing the new company name
		String compName = new String();
		compName = "Test Company";
		
		//Clear the existing company name and enter the new company name
		WebElement eleCompany = driver.findElementById("updateLeadForm_companyName");
		eleCompany.clear();
		eleCompany.sendKeys(compName,Keys.TAB);
		
		//Click on the update button
		driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
		Thread.sleep(5000);
		
		//Read the updated company name and assign to a variable
		String updCName = driver.findElementById("viewLead_companyName_sp").getText();
		
		//Verify the company name is displayed correctly with the update name
		if (updCName.contains(compName)) {
			System.out.println("Company name is updated successfully: " + updCName);
			
		} else {

			System.out.println("Company name is not updated successfully : " + updCName);
		}
		
		//Close the webpage
		driver.close();
	}

}
