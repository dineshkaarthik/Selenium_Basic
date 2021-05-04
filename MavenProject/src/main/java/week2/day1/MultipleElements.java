package week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleElements {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
		driver.get("http://www.leafground.com/pages/Link.html");
		
		 List<WebElement> linkElements = driver.findElementsByTagName("a");
		int noLinks = linkElements.size();
		System.out.println(noLinks);
		linkElements.get(0).click();
		driver.navigate().back();
		
		Thread.sleep(3000);
		 List<WebElement> linkElements1 = driver.findElementsByTagName("a");
		for (WebElement webElement : linkElements1) {
			String text = webElement.getText();
			System.out.println();
			
		}
	}

}
