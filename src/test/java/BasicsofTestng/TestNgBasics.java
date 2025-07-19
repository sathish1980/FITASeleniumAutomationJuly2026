package BasicsofTestng;

import org.testng.annotations.*;

public class TestNgBasics {
	
	
	
	
	@Test(priority=0,invocationCount=5,invocationTimeOut=60,groups="SIT")
	public void SecondTestcase()
	{
		System.out.println("SecondTestcase");
	}
	
	@Test(priority=-1,timeOut=60,groups="Sanity")
	public void ThirdTestcase()
	{
		System.out.println("ThirdTestcase");
	}
	
	@Test(priority=-2,groups="Sanity")
	public void FirstTestcase()
	{
		System.out.println("First Test case");
		//throw new ArithmeticException("Error ");
	}
	
	@BeforeMethod
	public void BeforeM()
	{
		System.out.println("Before MEthod");
	}

	@AfterMethod
	public void AfterM()
	{
		System.out.println("After MEthod");
	}

	@BeforeClass
	public void Beforec()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void Afterc()
	{
		System.out.println("After Class");
	}
	
	@AfterSuite
	public void afterS()
	{
		System.out.println("After Suite");
	}
}
