package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonUtils.WebElementCommons;

public class HomePage {
	
	WebDriver browser;
	
	public HomePage(WebDriver browser)
	{
		this.browser=browser;
	}
	
	public void closeAccountinfoPopup()
	{
		WebElementCommons.WaitForClickable(browser, By.xpath("//*[@data-cy='closeModal']"));
		WebElementCommons.ClickOnButton(browser.findElement(By.xpath("//*[@data-cy='closeModal']")));
	}

}
