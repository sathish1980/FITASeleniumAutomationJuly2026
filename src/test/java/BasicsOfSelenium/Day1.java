package BasicsOfSelenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {
	
	
	public void LauchtheBrowser()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.quit();
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Day1 D = new Day1();
		D.LauchtheBrowser();
		

	}

}
