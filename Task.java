package new1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C://webdriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://codeshare.io/");
		String parentid = driver.getWindowHandle();
		System.out.println(parentid);
		WebElement element = driver.findElement(By.xpath("//a[text()='Share Code Now']"));
		element.click();
		driver.switchTo().frame(1);
		//driver.findElement(By.xpath("//pre[@class=\" CodeMirror-line \"]")).sendKeys("#include");
		driver.switchTo().newWindow(WindowType.TAB).get("https://codeshare.io/vwY3Ny");
		//driver.findElement(By.xpath("//pre[@class=\" CodeMirror-line \"]")).sendKeys("#include <stdio.h>");
		//driver.findElement(By.xpath("//pre[@class=\" CodeMirror-line \"]")).sendKeys("#include <conio.h>");
		Set<String> parentchildid = driver.getWindowHandles();
		System.out.println(parentchildid);
		for(String i:parentchildid)
		{
			if(!i.equals(parentchildid))
			{
				driver.switchTo().window(parentid);
				System.out.println("switch to parent");
		    }			
		}
	}
}
