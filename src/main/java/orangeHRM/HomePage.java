package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	//apply explicit wait for multiple web elements
	WebDriver driver;//web driver object can be static or non static
	WebDriverWait wait;
	
	@FindBy(xpath="//span[text()='Admin']")
	private WebElement admin;
	
	@FindBy(xpath="//span[text()='Time']")
	private WebElement time;
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfo;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver,this);
	}
		
	public void verifyAdminTab() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
		boolean result=admin.isDisplayed();
		System.out.println(result);
	}
	
	public void verifyTimeTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Time']")));
		boolean result=time.isDisplayed();
		System.out.println(result);
	}
	
	public void verifyMyINfoTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Time']")));
		boolean result=myInfo.isDisplayed();
		System.out.println(result);
	}
	

}
