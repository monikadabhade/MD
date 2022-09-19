package testClass;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import orangeHRM.HomePage;
import orangeHRM.LogInPage;
import utility.GetExcelData;
import utility.Pojo;
import utility.Screenshot;


public class ExtendReport extends Pojo
{
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	
	@BeforeClass
	public void beforeClass()
	{
		driver=openChromeBrowser();	
		this.driver=driver;
		
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./test-output/rpt.html");
		 extent= new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("verifyLogInPage");
		 logger = extent.createTest("verifyHomePage");
		
	}
	
	@BeforeMethod
	public void brforeMethod() throws EncryptedDocumentException, IOException
	{
//		String data=GetExcelData.getData(1,1);
//		System.out.println(data);		
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
	public void verifyHomePage() throws InterruptedException
	{
		Thread.sleep(4000);
		HomePage home=new HomePage(driver);
//		boolean r=home.verifyAdminTab();
//		System.out.println(r);
		home.verifyTimeTab();
		home.verifyMyINfoTab();
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path =Screenshot.captureScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		
		extent.flush();
	}
	
	
}
