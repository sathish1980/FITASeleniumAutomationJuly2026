package TestCase;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import BrowserUtils.OPenBrowser;
import CommonUtils.WebElementCommons;
import Utils.PropertyFileRead;

public class MakeMyTripFlightSearch extends OPenBrowser{
	
	PropertyFileRead p = new PropertyFileRead();
	
	@BeforeSuite
	public void OpenTheBrowser() throws IOException
	{
	
		String browername = p.GetEnvPropertyData().getProperty("browser");
		LaunchTheBrowser(browername);
	}
	
	@BeforeTest
	public void LaunchMakeMyTrip() throws IOException
	{
		String url = p.GetEnvPropertyData().getProperty("url");
		WebElementCommons.OpentheApplication(browser,url);
	}
	
	@Test
	public void MakeMyTripFlightSearchWithValidValues()
	{
		
	}
	
	@AfterSuite
	public void TearDown()
	{
		browser.quit();
	}

}
