   package amazon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LadiesShoulderBag 
{

	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Java\\Window7\\First\\RichARich\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("travel cotton bags");
		String ParentWindow = driver.getWindowHandle(); 
		
		//KeyBoard capabalities - Robot Class 
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//Actions for cursor
		Actions a = new Actions(driver);
		
		
		WebElement Next = driver.findElement(By.xpath("//a[text()='Next']"));
		WebElement RnR = null;
		
		//Implementing explicit waits concept
		WebDriverWait w = new WebDriverWait(driver, 100);
		
		
		for (int i = 0; i < 10; i++) 
		{
			Next = driver.findElement(By.xpath("//a[text()='Next']"));
			System.out.println("entered inside for "+RnR);
			Thread.sleep(3000);
			
			if (RnR == null) 
			{
				System.out.println("entered inside if"+RnR);
				try 
				{
					RnR = driver.findElement(By.xpath("//span[text()='Rich & Rich Ladies Shoulder Bag Bird Design']"));
					//w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Rich & Rich Ladies Shoulder Bag Bird Design']"))).click();
					a.moveToElement(RnR).click(RnR).build().perform();
				} 
				catch (Exception e) 
				{
					a.moveToElement(Next).click(Next).build().perform();
					System.out.println("entered inside catch"+RnR);
				}
	
			}
			else 
			{
				Set<String> AllWindows = driver.getWindowHandles();
				System.out.println("already the element is available");
				for (String check : AllWindows) 
				{
					
					if (!check.equals(ParentWindow)) 
					{
						System.out.println("entered inside else--for--if");
						driver.switchTo().window(check);
						List<WebElement> Elements = driver.findElements(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-none']//li"));
						
						for (WebElement string : Elements) 
						{
							System.out.println(string.getText());
						}
						
					}
				
				}
				
				
			}
			
			
		}
	
		
	}     

}
