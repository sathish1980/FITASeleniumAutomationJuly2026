package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcepts {
	
	public void DropdownInplementation(String expectedCountry)
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/select.xhtml");
		browser.findElement(By.xpath("//*[@id='j_idt87:country']//*[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"))));
		
		List<WebElement> allCountry = browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		
		for (WebElement eachCountry: allCountry)
		{
			wait.until(ExpectedConditions.elementToBeClickable(eachCountry));
			
			String actualCountry = eachCountry.getText();
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				eachCountry.click();
				break;
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Listconcepts L = new Listconcepts();
		L.DropdownInplementation("India");
		

	}

}
