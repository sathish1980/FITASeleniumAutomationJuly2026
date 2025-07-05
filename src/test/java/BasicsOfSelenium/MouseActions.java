package BasicsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public void MouseActionsInplementation() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.ebay.com/");
		WebElement electronics = browser.findElement(By.xpath("//li[@class='vl-flyout-nav__js-tab']//a[text()='Electronics']"));
		
		Actions action = new Actions(browser);
		action.moveToElement(electronics).build().perform();
		Thread.sleep(1000);
		action.moveToElement(browser.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().build().perform();
		
	}
	
	public void MouseActionsInplementation2() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/drag.xhtml;");
		
		Actions action = new Actions(browser);
		action.moveToElement(browser.findElement(By.id("form:drag"))).dragAndDrop(browser.findElement(By.id("form:drag")), browser.findElement(By.id("form:drop_content"))).build().perform();
		
		
		action.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), 160, 0).build().perform();
		Thread.sleep(1000);
		action.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), -100, 0).build().perform();
	}
	
	
	public void MouseActionsInplementation3() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions action = new Actions(browser);
		
		action.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").doubleClick().contextClick().build().perform();
		
	}
	
	
	public void KeyboardActions() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions action = new Actions(browser);
		
		action.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").build().perform();
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
		
		Thread.sleep(1000);
		action.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").doubleClick().build().perform();
		action.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
	}
	
	public void KeyboardActions1() throws InterruptedException, AWTException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		Actions action = new Actions(browser);
		
		action.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").doubleClick().build().perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.KeyboardActions1();
		

	}

}
