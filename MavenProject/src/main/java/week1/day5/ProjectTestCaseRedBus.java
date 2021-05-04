package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectTestCaseRedBus {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch the applicaion
		driver.get("https://redbus.in");
		
		//Enter user name
		WebElement eleSRC = driver.findElementByXPath("(//input[@class='db'])[1]");
		eleSRC.sendKeys("Chennai");
		Thread.sleep(3000);
		eleSRC.sendKeys(Keys.TAB);
		
		//Enter To city
		WebElement eleToCity = driver.findElementByXPath("(//input[@class='db'])[2]");
		eleToCity.sendKeys("Bangalore");
		Thread.sleep(3000);
		eleToCity.sendKeys(Keys.TAB);
		
		//Click onward Date
		//driver.findElementById("onward_cal").click();
		//Thread.sleep(10000);
		//Select Date
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		
		
		//Click on the Search button
		driver.findElementById("search_btn").click();
		
		Thread.sleep(4000);
		
		//Select the After 6pm checkbox
		
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		
		//Select the Sleeper checkbox
		Thread.sleep(3000);
		driver.findElementByXPath("//label[@title='SLEEPER']").click();
		Thread.sleep(2000);
		
		//Click Seat available for sorting
		
		driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();

		
	}

}
