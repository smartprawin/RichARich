package amazon;


import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class LadiesFrill 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\RichARich\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?me=AN2M66VNZRHYV&marketplaceID=A21TJRUUN4KGV");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement ladiesfrill = driver.findElement(By.xpath("//span[contains(text(),'Rich & Rich Ladies Frill Multicolor Shoulder Bag RR156-I')]"));
		Thread.sleep(5000);
		Actions moveToElement = action.moveToElement(ladiesfrill);
		Thread.sleep(2000);
		moveToElement.click(ladiesfrill).build().perform();
		String parentwindow = driver.getWindowHandle();
		Set<String> childwindow = driver.getWindowHandles();
		for (String string : childwindow) 
		{
		if (!string.equals(parentwindow)) 
		{
			System.out.println("inside child");
			driver.switchTo().window(string);
			List<WebElement> printingDetails = driver.findElements(By.xpath("//div[@id='feature-bullets']/ul/li"));
			for (WebElement pd : printingDetails) 
			{
				System.out.println(pd.getText());
			}
		}	System.out.println("successfully executed");
		}
	}

}
