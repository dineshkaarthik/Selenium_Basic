package week1.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTapsLogin {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.sendKeys("DemoSalesManager");
		
		WebElement elePassword = driver.findElementById("password");
		elePassword.sendKeys("crmsfa");
		
		WebElement eleSubmit = driver.findElementByClassName("decorativeSubmit");
		eleSubmit.click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Test Company");
		Thread.sleep(100);
		//driver.findElementByName("firstName").sendKeys("Dinesh");
		driver.findElementById("createLeadForm_firstName").sendKeys("Dinesh");
		driver.findElementById("createLeadForm_lastName").sendKeys("Thangavelu");
		driver.findElementByClassName("smallSubmit").click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String expTitle = new String();
		expTitle = "View Lead | opentaps CRM";
		if (pageTitle.contains(expTitle)) {
			System.out.println("Title displayed correctly "+ pageTitle );
		} else {
			System.out.println("Title not displayed correctly" + pageTitle);
		}
		
		
		driver.close();
		
		
		
		
	}

}
