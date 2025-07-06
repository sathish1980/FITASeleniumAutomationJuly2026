package BasicsOfSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	public void WebTablemplementation(String expectedCountry) throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/table.xhtml");
		
		List<WebElement> allPages = browser.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		for(int j=1;j<=allPages.size();j++)
		{
			browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
		Thread.sleep(2000);
		List<WebElement> allRows = browser.findElements(By.xpath("//*[@id='form:j_idt89_data']//tr"));
		
		for(int i=1;i<=allRows.size();i++)
		{
			String actualCountry =  browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[2]//span[contains(@style,'vertical')]")).getText();
			if(actualCountry.equalsIgnoreCase(expectedCountry))	
			{
				String representative = browser.findElement(By.xpath("//*[@id='form:j_idt89_data']//tr["+i+"]//td[3]//span[contains(@style,'vertical')]")).getText();
				System.out.println(representative);
			}
		}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.WebTablemplementation("France");
	}

}
