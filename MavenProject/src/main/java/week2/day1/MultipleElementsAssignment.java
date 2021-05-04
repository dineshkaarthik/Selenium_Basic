package week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleElementsAssignment {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
		driver.get("http://www.leafground.com/pages/Image.html");
		
		 List<WebElement> imgElements = driver.findElementsByTagName("img");
		int noImages = imgElements.size();
		System.out.println(noImages);
		imgElements.get(noImages-1).click();
		Thread.sleep(4000);
		driver.findElementByXPath("//h5[text()='Radio Button']").click();
		Thread.sleep(3000);
		
		
		 List<WebElement> radioElements = driver.findElementsByXPath("//input[@type='radio']");
		 int noRadio = radioElements.size();
			System.out.println(noRadio);
		//linkElements.get(0).click();
		driver.navigate().back();
			
		Thread.sleep(4000);
		driver.findElementByXPath("//img[@alt='Checkbox']").click();
		Thread.sleep(2000);
		
		 List<WebElement> cbElements = driver.findElementsByXPath("//input[@type='checkbox']");
		 int noCB = cbElements.size();
			System.out.println(noCB);
			for (WebElement eleCheckbox : cbElements) {
				eleCheckbox.click();
				
			}
			
		
		
		
	}

}
