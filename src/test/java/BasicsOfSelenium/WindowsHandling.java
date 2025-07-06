package BasicsOfSelenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {
	
	public void WindowsImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/window.xhtml");
		
		String parentWindow = browser.getWindowHandle(); // get the current window name
		
		browser.findElement(By.id("j_idt88:new")).click();
		
		Set<String> allWindows = browser.getWindowHandles();
		
		for (String eachWindow : allWindows)
		{
			if(!eachWindow.equalsIgnoreCase(parentWindow))
			{
				browser.switchTo().window(eachWindow); // navigate to respective window
				
				List<WebElement> elementExist = browser.findElements(By.xpath("//*[@id='menuform:j_idt37']//li[@id='menuform:j_idt40']//span[text()='Element']//ancestor::a"));
				 if(elementExist.size()>0)
				 {
					 browser.findElement(By.xpath("//*[@id='menuform:j_idt37']//li[@id='menuform:j_idt40']//span[text()='Element']//ancestor::a")).click();
					 browser.findElement(By.xpath("//li[@id='menuform:m_input']//a")).click();
					 browser.findElement(By.id("j_idt88:name")).sendKeys("FITA");
					 browser.switchTo().window(parentWindow);
					 break;
					 
				 }
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandling F =  new WindowsHandling();
		F.WindowsImplementation();
	}

}
