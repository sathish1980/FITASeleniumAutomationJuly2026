package BasicsofTestng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgThirdclass {

	@Test(priority=1,groups="Sanity")
	public void Thirdcalss1()
	{
		System.out.println("Thirdcalss1");
	}
	
	@BeforeTest
	public void beforeT()
	{
		System.out.println("Before Test");
	}
}
