package week3.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MyntraProject {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
				driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
				//driver.manage().window().maximize();
				
				Thread.sleep(3000);
				driver.switchTo().frame("iframeResult");
				driver.findElementByXPath("//button[text()='Try it']").click();
				Thread.sleep(3000);
				
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				
				
	}

}
