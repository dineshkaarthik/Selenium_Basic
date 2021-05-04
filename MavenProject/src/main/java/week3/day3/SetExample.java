package week3.day3;

import java.util.ArrayList;
import java.util.Collections;
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

public class SetClassWork {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//Create instance for the Chromedriver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
				driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
				//driver.manage().window().maximize();
				
				Thread.sleep(3000);
				
				driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
				 ArrayList<String> arrayList = new ArrayList<String>();
				 
				
				List<WebElement> trainNames = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
				
				for (WebElement train : trainNames) {
					arrayList.add(train.getText());
				}
				
				int tnamecnt = arrayList.size();
				
				Collections.sort(arrayList);
				
				for (int i = 0; i <= tnamecnt; i++) {
					
					System.out.println(arrayList.get(i));
					
				}
				
	}

}
