package BrowserUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class OPenBrowser {

	public static WebDriver browser;
	
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
	}
}
