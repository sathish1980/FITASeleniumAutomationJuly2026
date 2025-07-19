package BasicsofTestng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGScondClass {
	
	@Test(priority=0,groups="Sanity")
	public void Fitatestcase1()
	{
		System.out.println("Fitatestcase1");
	}
	
	@Test(priority=1,groups="SIT")
	public void Fitatestcase2()
	{
		System.out.println("Fitatestcase2");
	}
	
	@AfterTest
	public void AfterT()
	{
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void beforeS()
	{
		System.out.println("Before Suite");
	}

}
