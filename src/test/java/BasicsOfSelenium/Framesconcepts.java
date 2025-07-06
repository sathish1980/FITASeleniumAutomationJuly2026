package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framesconcepts {
	
	public void FramesImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/frame.xhtml");
		/*WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Click' and contains(@style,'#fe875d')]")));*/
		
		List<WebElement> allFrames = browser.findElements(By.tagName("iframe"));
		
		for(int i=0;i<allFrames.size();i++)
		{
			browser.switchTo().frame(i);  // switch in to frame
			
			List<WebElement> elementExist = browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'#fe875d')]"));
			if(elementExist.size()>0)
			{
				browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'#fe875d')]")).click();
				browser.switchTo().defaultContent(); // switch out of frame
				break;
			}
			browser.switchTo().defaultContent();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Framesconcepts F = new Framesconcepts();
		F.FramesImplementation();
	}

}
