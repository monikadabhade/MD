package testClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import orangeHRM.HomePage;
import orangeHRM.LogInPage;
import utility.GetExcelData;
import utility.Pojo;
import utility.Screenshot;

public class TestClass1 extends Pojo
{
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		driver=openChromeBrowser();	
		this.driver=driver;
	
	}
	
	@BeforeMethod
	public void brforeMethod() throws EncryptedDocumentException, IOException
	{
		String data=GetExcelData.getData(1,1);
		System.out.println(data);		
		System.out.println("before method");
	}
	
	@Test(priority=0)
	public void verifyLogInPage() throws IOException, EncryptedDocumentException, InterruptedException
	{
		LogInPage login=new LogInPage(driver);
		login.sendUserName();
		login.sendPassword();
		login.clickLoginButton();
		System.out.println("LogIn Page Passed");
		
	}
	
	@Test(priority=1)
	public void verifyHomePage() throws InterruptedException, IOException
	{
		
		HomePage home=new HomePage(driver);
		home.verifyAdminTab();
		home.verifyTimeTab();
		home.verifyMyINfoTab();
		Screenshot.captureScreenshot(driver);
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		System.out.println("after class");
	}
	
	
}
