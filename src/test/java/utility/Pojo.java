package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Pojo
{
	public WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		return driver;
		
	}
	public WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\MONIKA\\SELENIUM\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		return driver;
		
	}
	
	
}
