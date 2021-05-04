package week4.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UnexpectedAlert {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Launch the applicaion
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("unhandledPromptBehavior", UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
	}

}
