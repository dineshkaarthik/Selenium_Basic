package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
				driver.get("http://www.leafground.com/pages/table.html");
				//driver.manage().window().maximize();
				
				WebElement eleTable = driver.findElementById("table_id");
				List<WebElement> eleRows = eleTable.findElements(By.tagName("tr"));
				//System.out.println(eleRows.size());
				int rowSize = eleRows.size();
				System.out.println(rowSize);
				List<WebElement> eleColumns = eleRows.get(1).findElements(By.tagName("td"));
				System.out.println(eleColumns.size());
				int colSize = eleColumns.size();
				String str = new String();
				int temp;
				temp = 100;
				for (int i = 1; i < rowSize ; i++) {
					//System.out.println("row number: "+i);
					WebElement row = eleRows.get(i);
					List<WebElement> elecolumn = row.findElements(By.tagName("td"));
					//System.out.println(elecolumn.size());
					String sld = elecolumn.get(0).getText();
					String varTempProg = elecolumn.get(1).getText();
					str = varTempProg.substring(0, 2);
					//System.out.println(str);
					int prog = Integer.parseInt(str);
							System.out.println(prog);
					if (prog<temp) {
						temp = prog;
						int exprcnt = i;
						
					}
					//System.out.println(sld);
					if (sld.contains("Learn to interact with Elements")) {
						String progress = elecolumn.get(1).getText();
						System.out.println(progress);
					}
					
							}
				
				
				
				
				
				
	}

}
