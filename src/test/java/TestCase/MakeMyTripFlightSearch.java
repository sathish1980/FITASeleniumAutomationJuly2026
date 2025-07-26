package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import BrowserUtils.OPenBrowser;
import CommonUtils.WebElementCommons;
import Pages.FlightSearchPage;
import Pages.HomePage;
import Utils.ExcelfileReadData;
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
	
	@Test(priority =0)
	public void MakeMyTripFlightSearchWithValidValues() throws InterruptedException
	{
		test = extent.createTest("SearchWithValidValues Testcase");
		HomePage H = new HomePage(browser);
		H.closeAccountinfoPopup();
		test.log(Status.INFO, "Pop closed succesfully");
		FlightSearchPage Fs = new FlightSearchPage(browser);
		Fs.ClickFromLocationdropdown();
		test.log(Status.INFO, "Dropdown clikced");
		Fs.SelectValueFromList("BOM");
		test.log(Status.INFO, "From selected as BOM");
		Fs.ClickToLocationdropdown();
		test.log(Status.INFO, "To Dropdown clikced");
		Fs.SelectValueFromList("MAA");
		test.log(Status.INFO, "To selected as MAA");
		Fs.SelectDate("28");
		test.log(Status.INFO, "Date selected sucessfully");
		Fs.clickOnSearchbutton();
		test.log(Status.INFO, "Searchbutton clikced");
		
		Assert.assertEquals(Fs.GetSearchResult(), "200-OK");
	}
	
	@Test(priority=1,dataProvider="GetValidflightSearchTestdata",dataProviderClass=DataProviderclass.class)
	public void MakeMyTripFlightSearchWithValidValuesusingmultipledata(String from,String to,String date) throws InterruptedException
	{
		test = extent.createTest("SearchWithValidValues with muitple data Testcase");
		WebElementCommons.ClickBackButton(browser);
		FlightSearchPage Fs = new FlightSearchPage(browser);
		Fs.ClickFromLocationdropdown();
		test.log(Status.INFO, "Dropdown clikced");
		Fs.SelectValueFromList(from);
		test.log(Status.INFO, "From selected as BOM");
		Fs.ClickToLocationdropdown();
		test.log(Status.INFO, "To Dropdown clikced");
		Fs.SelectValueFromList(to);
		test.log(Status.INFO, "To selected as MAA");
		Fs.SelectDate(date);
		test.log(Status.INFO, "Date selected sucessfully");
		Fs.clickOnSearchbutton();
		test.log(Status.INFO, "Searchbutton clikced");
		
		Assert.assertEquals(Fs.GetSearchResult(), "200-OK");
		Assert.assertEquals(Fs.getFromLocation(), from.toUpperCase());
		Assert.assertEquals(Fs.getToLocation(), to.toUpperCase());
	}
	
	@AfterMethod
	public void WriteInReport(ITestResult result) throws IOException, InterruptedException
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			String filePath = WebElementCommons.GetScreenshot(browser,result.getName());
		     test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is passed");

        }else if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is FAILED");
            String filePath = WebElementCommons.GetScreenshot(browser,result.getName());
            test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.SKIP,"Test Method named as : "+ result.getName()+" is skipped");
        }
	}
	
	
	@Test(priority=2)
	public void MakeMyTripFlightSearchWithinValidValues()
	{
		test = extent.createTest("SearchWithinValidValues Testcase");
		test.log(Status.INFO, "Enter u name");
		test.log(Status.INFO, "Enter  invalid password");
		test.log(Status.INFO, "Enter login button");
	}
	
	@AfterSuite
	public void TearDown()
	{
		CloseReport();
		browser.quit();
	}
	
	

}
