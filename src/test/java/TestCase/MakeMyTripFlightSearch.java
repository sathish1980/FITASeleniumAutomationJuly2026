package TestCase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

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
		test = extent.createTest("SearchWithValidValues Testcase");
		test.log(Status.INFO, "Enter user name");
		test.log(Status.INFO, "Enter password");
		test.log(Status.INFO, "Enter login button");
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
	
	
	@Test
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
