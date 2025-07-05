package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public void DropdownInplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/select.xhtml");
		
		WebElement UiAutomationTool = browser.findElement(By.xpath("//*[@class='ui-selectonemenu']"));
		
		Select dropdown = new Select(UiAutomationTool);
		dropdown.selectByIndex(1);
		dropdown.selectByVisibleText("Playwright");
		//dropdown.selectByValue(null)
		/*
		 * SelectByIndex
		 * SelectByVisibleText
		 * SelectByValue
		 * deSelectByIndex
		 * deSelectByVisibleText
		 * deSelectByValue
		 * deSelectAll
		 * 
		 */
		
		System.out.println(dropdown.isMultiple());
		
		/*
		 * 
		 */
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dropdown D =new Dropdown();
		D.DropdownInplementation();
		

	}

}
