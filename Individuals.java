package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Individuals extends BaseClass {
	
	@BeforeTest
	public void excelName() {
	excelName="Individuals";
	}
	
	@BeforeTest
	public void browserName() {
		browserName="edge";
	}
	
	
	@Test(dataProvider = "data")
	public void individuals(String lastName ) throws InterruptedException {
//	03) Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	04) Click View All
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
//	05) Type Individuals on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
//	06) Click Individuals Link
		driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
//	07) Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
//	08) Select Salutation with data (coming from excel)
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='Ms.']")).click();
//	09) Type Last Name
		driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys(lastName);
//	10) Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
//	11) Click on the App Launcher (dots)
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(appLauncher));
		appLauncher.click();
//	12) Click View All
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
//	13) Type Customers on the Search box
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Customers");
//	14) Click Customers Link
		driver.findElement(By.xpath("//mark[text()='Customers']")).click();
//	15) Click New
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']")).click();
//	16) Type the same name provided in step 8 and confirm it appears
		WebElement party = driver.findElement(By.xpath("//input[@title='Search Individuals']"));
		wait.until(ExpectedConditions.visibilityOf(party));
		party.sendKeys(lastName);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']//mark")).getText();
		if (text.equals(lastName)) {
			System.out.println("The name provided appears in search suggestions as expected");
		}
	}

}
