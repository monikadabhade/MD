package orangeHRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage 
{
	//apply explicit wait for a web element
	
     WebDriver driver;//web driver object can be static or non static
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public LogInPage(WebDriver driver)
	{   
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public void sendUserName()
	{	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		username.sendKeys("Admin");
	}
	
	public void sendPassword()
	{
		password.sendKeys("admin123");
	}
	
	public boolean clickLoginButton()
	{
		boolean result=login.isDisplayed();
		login.click();
		return result;
	}
	

}
