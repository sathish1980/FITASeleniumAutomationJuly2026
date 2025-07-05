package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcepts2 {
	
	public void listInplementation(String expectedCountry)
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.makemytrip.com/");
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-cy='closeModal']")));
		
		browser.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
		browser.findElement(By.xpath("//*[@for='fromCity']")).click();
		
		
		List<WebElement> allCountry = browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
		
		/*for (WebElement eachCountry: allCountry)
		{
			wait.until(ExpectedConditions.elementToBeClickable(eachCountry));
			
			String actualCountry = eachCountry.findElement(By.xpath("//div[starts-with(@class,'font14')]")).getText();
			System.out.println(actualCountry);
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachCountry.click();
				break;
			}
		}*/
		
		for(int i=1;i<allCountry.size();i++)
		{
			String actualCountry =  browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]//div[starts-with(@class,'font14')]")).getText();
			System.out.println(actualCountry);
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]")).click();
				break;
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Listconcepts2 L = new Listconcepts2();
		L.listInplementation("BKK");
		

	}

}
