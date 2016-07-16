package pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class WellsFargo {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new FirefoxDriver();
		driver.get("https://www.wellsfargo.com/");
		driver.manage().window().maximize();
		
		
		WebElement personal = driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		System.out.println(personal.getText());
		
		WebElement abtWellsFargo=driver.findElement(By.xpath(".//*[@id='headerTools']/nav/ul/li[2]/a"));
		abtWellsFargo.click();
		
		System.out.println(driver.getTitle());
		
		WebElement home = driver.findElement(By.xpath(".//*[@id='pageFooter']/div[1]/nav/div/ul/li[5]/a"));
		home.click();
		
		
		WebElement personaltab = driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		System.out.println(personaltab.getText());
		
		
		WebElement insurance = driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
		insurance.click();
		
		
		WebElement homeOwners = driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
		homeOwners.click();
		
		Thread.sleep(3000);
		
				
		WebElement zipCode =driver.findElement(By.xpath(".//*[@id='zipCode']"));
		zipCode.sendKeys("12345");
		
		

	}

}
