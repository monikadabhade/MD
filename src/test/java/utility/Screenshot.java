package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot
{
	
	public static String captureScreenshot(WebDriver driver) throws IOException
	{		
//	    LocalTime time = LocalTime.now();
//	    System.out.println(time);
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="test-output\\ss\\abc.png";
		File dest=new File(path);
		FileHandler.copy(Source, dest);
		return path;
		
	}
	
	
	
	
}
