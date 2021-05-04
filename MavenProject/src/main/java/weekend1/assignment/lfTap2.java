package weekend1.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WeekendAssignment2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		//Set system properties for chrome driver
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
	    ops.addArguments("--disable-notifications");
	    ChromeDriver driver = new ChromeDriver(ops);
		//Create instance for the Chromedriver
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Launch the application
		driver.get("https://www.myntra.com/");
		
		//Mouse over on Women
		WebElement eleWomen = driver.findElementByXPath("//a[text()='Women']");
		Actions builder = new Actions(driver);
		
		builder.moveToElement(eleWomen).perform();
		
		//Click on the Jacket/coats link
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		
		Thread.sleep(3000);
		//Get total count
		String strCountLabel = driver.findElementByClassName("title-count").getText();
	     
		//Parse the count string and convert the count string to integer
	     String strCount = strCountLabel.replaceAll("\\D","");
	     int totCount = Integer.parseInt(strCount);
		System.out.println("Total count of Items is: "+totCount);
		
		//Get the category Jacket count
		String strJCnt = driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span").getText();
		 String strJCount = strJCnt.replaceAll("\\D","");
		int intJCnt = Integer.parseInt(strJCount);
		System.out.println("jacket count: "+intJCnt );
		//Get the category coats count
		String strCTcnt = driver.findElementByXPath("//input[@value='Coats']/following-sibling::span").getText();
		
		//Parse the count string to integer
		String strCTCount = strCTcnt.replaceAll("\\D","");
		int intCTcnt = Integer.parseInt(strCTCount);
		System.out.println("Coats count is: "+ intCTcnt);
		
		//Validate the total of jacket and coats count matches the category total count 
		if (totCount == intJCnt + intCTcnt ) {
			
			System.out.println("Total category count is correct");
			
		}
		Thread.sleep(4000);
		//Check the Coats checkbox
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		//driver.findElementByXPath("//input[@value='Coats']").click();
		Thread.sleep(4000);
		
		//Click + More option under BRAND 
		driver.findElementByClassName("brand-more").click();
		
		//Type Mango
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Mango");
		//Check the Mango check box
		Thread.sleep(4000);
		driver.findElementByXPath("//span[@class='FilterDirectory-count']/following-sibling::div[1]").click();
		Thread.sleep(3000);
		//Click on the close button
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(4000);
		//Get all the brand names and verify correct brand name is displayed
		List<WebElement> eleBrands = driver.findElementsByClassName("product-brand");
		
		for (WebElement brand : eleBrands) {
			
			String brandName = brand.getText();
			
			if (brandName.contentEquals("MANGO")) {
				
				System.out.println("Brand name displayed correctly: "+brandName );
				
			} else {
				
				System.out.println("Brand name wrongly displayed: "+ brandName);

			}
			
		}
		
		//select Better Discount from the dropdown
		driver.findElementByXPath("//div[@class='sort-sortBy']").click();
		driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
		
		Thread.sleep(6000);
		//Get the price of all the products listed
		List<WebElement> elePrices = driver.findElementsByClassName("product-discountedPrice");
		
		//Parse the price string to integer
		String strprice = elePrices.get(0).getText();
		String price = strprice.replaceAll("\\D","");
		int intPrice = Integer.parseInt(price);
		
		//Print the price
		System.out.println("Price of the first product displayed is: "+intPrice );
		
		//Mover over on size of the first item
		WebElement eleSize = driver.findElementByXPath("(//div[@class='product-productMetaInfo'])[1]");
		builder.moveToElement(eleSize).perform();
		Thread.sleep(2000);
		//Click on wishlist
		driver.findElementByXPath("(//div[@class='product-actions product-prelaunchActions'])[1]/span").click();
		
		
		
		
		
		
		
			}

}
