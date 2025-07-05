package BasicsOfSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsClass {
	
	String expectedMessage = "You have successfully clicked an alert";
	public void AlertsImplementation()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/alert.xhtml");
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		browser.switchTo().alert().accept();
		String actualMessage = browser.findElement(By.id("simple_result")).getText();
		if(actualMessage.equalsIgnoreCase(expectedMessage))
		{
			System.out.println("True");
		}
		browser.findElement(By.id("j_idt88:j_idt93")).click();
		browser.switchTo().alert().dismiss();
		
		browser.findElement(By.id("j_idt88:j_idt104")).click();
		Alert a = 	browser.switchTo().alert();
		System.out.println(browser.switchTo().alert().getText());
		a.sendKeys("FITA");
		a.accept();
		
		//Assertion
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlertsClass A = new AlertsClass();
		A.AlertsImplementation();
	}

}
