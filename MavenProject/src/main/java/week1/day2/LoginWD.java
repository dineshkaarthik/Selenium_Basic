package week1.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		String title = driver.getTitle();
		System.out.println(title);
		driver.navigate().refresh();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		
		driver.close();
	}

}
