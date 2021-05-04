package week1.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
						
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.findElementById("email").sendKeys("dineshkaarthikt@gmail.com",Keys.TAB);
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").clear();
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys("test");
		String valattribute = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input").getAttribute("value");
		System.out.println(valattribute);
		boolean val = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
		System.out.println(val);
		
	}

}
