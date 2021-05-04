package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

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
						
				driver.findElementByXPath("//a[text()='Create Lead']").click();
				
				driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Test Company");
				
				driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Dinesh");
						
				WebElement DD = driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']");
				
				Select ddDataSource = new Select(DD);
				ddDataSource.selectByVisibleText("Conference");
				
				WebElement DD2 = driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']");
				
				Select ddIndustry = new Select(DD2);
				
				List<WebElement> options = ddIndustry.getOptions();
				int cnt = options.size();
				System.out.println(cnt);
				ddIndustry.selectByIndex(cnt-1);
				
				
				
	}

}
