package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.WebElementCommons;


public class FlightSearchPage {
	
	WebDriver driver;

	public FlightSearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void SelectFromLocation(String from)
	{
		ClickFromLocationdropdown();
		SelectValueFromList(from);
	}
	
	public void SelectToLocation(String to)
	{
		ClickToLocationdropdown();
		SelectValueFromList(to);
	}
	
	public void SelectDate(String expectedDate) throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement> allWeeks = driver.findElements(By.xpath("(//*[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[last()]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeek : allWeeks)
		{
			List<WebElement> allDaysInaWeek=	eachWeek.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for (WebElement eachday : allDaysInaWeek)
			{
				
				String className = WebElementCommons.GetAttribute(eachday,"class");
				if(!(className.contains("outside")||className.contains("disabled")||className.contains("selected")))
				{
					String actualDate =WebElementCommons.GetText(eachday.findElement(By.tagName("p")));
					System.out.println(actualDate);
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						WebElementCommons.ClickOnButton(eachday);
						return ;
					}
				}
			}
		}
	}
	
	public void clickOnSearchbutton()
	{
		WebElementCommons.WaitForClickable(driver, By.xpath("//a[text()='Search']"));
		WebElementCommons.ClickOnButton(driver.findElement(By.xpath("//a[text()='Search']")));

	}
	public void ClickFromLocationdropdown()
	{
		WebElementCommons.WaitForClickable(driver, By.cssSelector("[for='fromCity']"));
		WebElement from = driver.findElement(By.cssSelector("[for='fromCity']"));
		WebElementCommons.ClickOnButton(from);

	}
	
	public void ClickToLocationdropdown()
	{
		WebElementCommons.WaitForClickable(driver, By.cssSelector("[for='toCity']"));
		WebElement to = driver.findElement(By.cssSelector("[for='toCity']"));
		
		WebElementCommons.ClickOnButton(to);
	}
	
	public void SelectValueFromList(String selectValue)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		
		List<WebElement> allcountry =driver.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			String Code = eachElement.findElement(By.cssSelector("div[class^='font14']")).getText();
			System.out.println(Code);
			if(Code.equalsIgnoreCase(selectValue))
			{
				eachElement.click();
				break;
			}
		}
	}
	
	
	public String GetSameCityError()
	{
		WebElementCommons.WaitForVisible(driver, By.cssSelector("[data-cy='sameCityError']"));
		
		return WebElementCommons.GetText(driver.findElement(By.cssSelector("[data-cy='sameCityError']")));
	}


	public String GetSearchResult()
	{
		return WebElementCommons.GetText(driver.findElement(By.xpath("//*[text()='200-OK']")));
	}

	public String getFromLocation()
	{
		String currenturl = WebElementCommons.GetCurrentUrl(driver);
		//https://www.makemytrip.com/flight/search?itinerary=BOM-DEL-27/08/2025&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng
		String[] afterSpliturl = currenturl.split("=");
		return afterSpliturl[1].split("-")[0];
	}
	public String getToLocation()
	{
		String currenturl = WebElementCommons.GetCurrentUrl(driver);
		//https://www.makemytrip.com/flight/search?itinerary=BOM-DEL-27/08/2025&tripType=O&paxType=A-1_C-0_I-0&intl=false&cabinClass=E&lang=eng
		String[] afterSpliturl = currenturl.split("=");
		return afterSpliturl[1].split("-")[1];
	}
}


