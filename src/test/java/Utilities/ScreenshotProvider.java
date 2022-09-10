package Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotProvider {
	
	public static String ScreenshotsSubFOlderName;
	
	public static void CaptureScreenshot(WebDriver driver, String MethodName)  {
		
		if(ScreenshotsSubFOlderName == null) {
			
			LocalDateTime myTime = LocalDateTime.now();
			DateTimeFormatter dft= DateTimeFormatter.ofPattern("yyyyMMddhhMMss");
			ScreenshotsSubFOlderName = dft.format(myTime);
			System.out.println("Sub folder is created using :-"+ScreenshotsSubFOlderName);
		}
			
		SimpleDateFormat dft= new SimpleDateFormat("YYYY-MM-dd HH:MM:SS");
		
		TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
		
		File source =takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Screenshots/"+ScreenshotsSubFOlderName+"/"+MethodName+".jpeg");
		
		try {
		FileUtils.copyFile(source, destination);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

}
