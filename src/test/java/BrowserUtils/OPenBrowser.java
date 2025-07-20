package BrowserUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class OPenBrowser {

	
	public static WebDriver browser;
	public String reportPath = System.getProperty("user.dir")+"\\Reprots\\selenium.html";
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test;
	
	
	public void LaunchTheBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incongnito");
		options.addArguments("–disable-notifications");
		browser = new ChromeDriver(options);
		}
		else
		{
			browser = new EdgeDriver();
		}
		browser.manage().window().maximize();
		OpenReport();
	}
	
	public void OpenReport()
	{
		htmlReporter = new ExtentSparkReporter(reportPath);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	}
	
	public void CloseReport()
	{
		extent.flush();
	}
}
