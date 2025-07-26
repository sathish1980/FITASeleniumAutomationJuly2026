package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelfileReadData;

public class DataProviderclass {
	@DataProvider
	public Object[][] GetValidflightSearchTestdata() throws IOException
	{
		return ExcelfileReadData.ReadData("ValidData");
	}
}
