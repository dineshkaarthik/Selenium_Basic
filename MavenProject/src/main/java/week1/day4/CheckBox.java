package week1.day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Link.html");
		
		
		String attribute = driver.findElementByXPath("(//a[@link='blue'])[2]").getAttribute("href");
		
		System.out.println(attribute);
		
		driver.findElementByXPath("//a[@href='error.html']").click();
		String title = driver.getTitle();
		
		if (title.contains("404")) {
			System.out.println("link is broken");
			
		} else {
			System.out.println("link is not broken");

		}
		
		
	}

}
