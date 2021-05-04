package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ServiceNowAssignment {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String chWH = "";
		//Launch the application
				driver.get("https://dev92474.service-now.com/");
				driver.manage().window().maximize();
				
				driver.switchTo().frame("gsft_main");
				driver.findElementById("user_name").sendKeys("admin");
				driver.findElementById("user_password").sendKeys("India@123");
				driver.findElementById("sysverb_login").click();
				Thread.sleep(5000);
				driver.findElementById("filter").sendKeys("Incident",Keys.ENTER);
				Thread.sleep(3000);
				driver.findElementByXPath("(//div[text()='Create New'])[1]").click();
				Thread.sleep(6000);
				driver.switchTo().frame("gsft_main");
				String incidentID = driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
				System.out.println(incidentID);
				String parentWindow = driver.getWindowHandle();
				driver.findElementById("lookup.incident.caller_id").click();
				
				Set<String> windowHandles = driver.getWindowHandles();
				 for (String wh : windowHandles) {
					
					 if (wh.equalsIgnoreCase(parentWindow)) {
						System.out.println("Parent window: "+wh);
					} else {
						 chWH = wh;

					}
					
				}
				
			
				driver.switchTo().window(chWH);
				driver.findElementByXPath("(//a[@role='button'])[7]").click();
				
				driver.switchTo().window(parentWindow);
				driver.switchTo().frame("gsft_main");
				WebElement categoryDD = driver.findElementById("incident.category");
				Select category = new Select(categoryDD);
				category.selectByValue("software");
				Thread.sleep(3000);
				WebElement subcategoryDD = driver.findElementById("incident.subcategory");
				Select subcategory = new Select(subcategoryDD);
				subcategory.selectByValue("email");
				Thread.sleep(3000);
				WebElement contactTypeDD = driver.findElementById("incident.contact_type");
				Select contactType = new Select(contactTypeDD);
				contactType.selectByValue("walk-in");
				
				Thread.sleep(3000);
				WebElement stateDD = driver.findElementById("incident.state");
				Select varstate = new Select(stateDD);
				varstate.selectByValue("2");
				
				Thread.sleep(3000);
				WebElement urgencyDD = driver.findElementById("incident.urgency");
				Select urgency = new Select(urgencyDD);
				urgency.selectByValue("1");
				
				driver.findElementById("lookup.incident.assignment_group").click();
				
				Set<String> allwindowHandles = driver.getWindowHandles();
				 for (String awh : allwindowHandles) {
					
					 if (awh.equalsIgnoreCase(parentWindow)) {
						System.out.println("Parent window: "+awh);
					} else {
						 chWH = awh;

					}
					
				}
				 driver.switchTo().window(chWH);
				
				List<WebElement> eleRoles = driver.findElementsByXPath("//a[@class='glide_ref_item_link']");
				
				int size = eleRoles.size();
				eleRoles.get(size-1).click();
				driver.switchTo().window(parentWindow);
				driver.switchTo().frame("gsft_main");
				driver.findElementById("incident.short_description").sendKeys("Creating Incident For the Purpose of Management");
				Thread.sleep(3000);
				driver.findElementById("sysverb_insert").click();
				Thread.sleep(4000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("gsft_main");
				driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(incidentID,Keys.ENTER);
				Thread.sleep(5000);
				
				//driver.switchTo().frame("gsft_main");gsft_main
				driver.findElementByXPath("//a[@class='linked formlink']").click();
				
				Thread.sleep(5000);
				
				 String actualIncident = driver.findElementById("incident.number").getAttribute("value");
				
				if (incidentID.contains(actualIncident)) {
					
					System.out.println("Incident ID is same");
					
				} else {
					
					System.out.println("Incident ID is not same");

				}
				
				Thread.sleep(3000);
				WebElement impactDD = driver.findElementById("incident.impact");
				Select impact = new Select(impactDD);
				impact.selectByValue("1");
				
				Thread.sleep(1000);
				
				driver.findElementById("incident.description").sendKeys("Successfully Created an incident",Keys.TAB);
				
				
				driver.findElementByXPath("//textarea[@id='activity-stream-work_notes-textarea']").sendKeys("Done Right");
				Thread.sleep(1000);
				driver.findElementById("sysverb_update").click();
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				driver.findElementByXPath("(//span[@class='caret'])[1]").click();
				driver.findElementByXPath("//a[text()='Logout']").click();
				driver.close();
	}

}
