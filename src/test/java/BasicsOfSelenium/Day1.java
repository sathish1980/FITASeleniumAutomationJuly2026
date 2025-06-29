package BasicsOfSelenium;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {
	
	
	public void LauchtheBrowser()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// to open the url
		//browser.get("https://www.google.com/");
		//or 
		browser.navigate().to("https://www.facebook.com/");
		/*browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		
		// Locators:
		/*
		 * Id
		 * name
		 * classname
		 * link text
		 * partial link text
		 */
		WebElement username = browser.findElement(By.id("email"));
		username.sendKeys("Sathish"); // enter the value in the text box
		username.clear(); // remove the value form text box
		
		browser.findElement(By.name("email")).sendKeys("kumar");
		
		//browser.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("FITA");
		
		//browser.findElement(By.linkText("Create new account")).click();
		
		//browser.findElement(By.partialLinkText("new account")).click();
		
		//tagandid
		browser.findElement(By.cssSelector("input#email")).sendKeys("FITA2025");
		
		// tagandclassname
		//browser.findElement(By.cssSelector("input.inputtext _55r1 _6luy")).sendKeys("latest");
		
		//tag and attribute
		browser.findElement(By.cssSelector("input[data-testid='royal-email']")).sendKeys("latest");
		
		//tag class and attribute
		//browser.findElement(By.cssSelector("input.inputtext _55r1 _6luy[data-testid='royal-email']")).sendKeys("latest");
		
		//Startswith
		browser.findElement(By.cssSelector("input[class^='inputtext']")).sendKeys("2026");
		
		//endswith
		browser.findElement(By.cssSelector("input[class$='uy']")).sendKeys("endsqwith");
		
		//contains
		
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(username));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class*='uy']")));
		
		browser.findElement(By.cssSelector("input[class*='uy']")).sendKeys("contains");
		browser.findElement(By.cssSelector("input[class*='uy']")).sendKeys("contains");
				
		//browser.quit();
		
		
		//Xpath
		//absolute xpath  -- not recomended
		browser.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/form/div/div/input")).clear();
		
		//relative xpath
		/*
		 * Basic xpath
		 * contains
		 * starts-with
		 * and or
		 * text
		 */
		
		browser.findElement(By.xpath("//*[@placeholder='Email address or phone number']")).sendKeys("BasicXpath");
		browser.findElement(By.xpath("//input[contains(@class,'_55r1 ') and @id='pass']")).sendKeys("containsand");
		
		browser.findElement(By.xpath("//input[starts-with(@class,'in') and @id='pass']")).sendKeys("starts-with");
		
		browser.findElement(By.xpath("//button[text()='Log in']")).click();
		
	
		
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Day1 D = new Day1();
		D.LauchtheBrowser();
		

	}

}
