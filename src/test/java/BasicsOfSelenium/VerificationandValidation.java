package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class VerificationandValidation {


	public void login() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		//browser.manage().window().minimize();
		browser.get("https://leafground.com/alert.xhtml");
		
		String Title = browser.getTitle();
		String url = browser.getCurrentUrl();
		String pg =browser.getPageSource();
		String name = browser.findElement(By.xpath("(//*[@name='j_idt88:j_idt91']//span)[last()]")).getText();
		String att= browser.findElement(By.xpath("(//*[@name='j_idt88:j_idt91']//span)[last()]")).getAttribute("Class");
		System.out.println(browser.getWindowHandle());
		System.out.println(browser.getWindowHandles());
		System.out.println(att);
		System.out.println(name);
		System.out.println(url);
		System.out.println(Title);
		
		/*
		 * isenabled()
		 * isdisplayed()
		 * isselected()
		 */
		
	}
	

}
