package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadiobuttonandCheckBox {
	
	public void LauchtheBrowser(String radioButtonSelection)
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/r.php?entry_point=login");
		if(radioButtonSelection.equalsIgnoreCase("male"))
		{
		browser.findElement(By.xpath("//*[text()='Male']//child::input")).click();
		}
		else if(radioButtonSelection.equalsIgnoreCase("female"))
		{
			browser.findElement(By.xpath("//*[text()='Female']//child::input")).click();
			
		}
		else
		{
			browser.findElement(By.xpath("//*[text()='Custom']//child::input")).click();
		}
		
	}
	
	public void CheckBoximplementation()
	{
		
		String url="https://leafground.com/checkbox.xhtml;";
		
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get(url);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:j_idt89']//div[starts-with(@class,'ui-chkbox-box')]")));
		
		browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//div[starts-with(@class,'ui-chkbox-box')]")).click();
		
		browser.findElement(By.className("ui-toggleswitch-slider")).click();
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-growl-title")));
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-growl-title")));
		
		browser.findElement(By.className("ui-toggleswitch-slider")).click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-growl-title")));
		
		System.out.println("done");
		browser.quit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadiobuttonandCheckBox R = new RadiobuttonandCheckBox();
		//R.LauchtheBrowser("Female");
		R.CheckBoximplementation();
	}

}
