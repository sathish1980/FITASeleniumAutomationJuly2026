package BasicsOfSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Screenshot {


	public void launch() throws IOException, InterruptedException
	{
	
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.leafground.com/dashboard.xhtml");
		captureScreenshot(browser,"Test");

		
	}

	public void captureScreenshot(WebDriver browser,String filename) throws IOException
	{
		TakesScreenshot scr = (TakesScreenshot)browser;
		File sourcefile =scr.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png");
		FileUtils.copyFile(sourcefile, destinationFile);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Screenshot S = new Screenshot();
		S.launch();
	}
	
}
