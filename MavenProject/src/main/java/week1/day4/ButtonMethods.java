package week1.day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonMethods {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		
		
		String color = driver.findElementByXPath("//h2[text()='Leaftaps Login']").getCssValue("background-color");
		
		System.out.println(color);
		
		String fontSize = driver.findElementByXPath("//label[@for='username']").getCssValue("font-size");
		System.out.println(fontSize);
		
		
		
	}

}
