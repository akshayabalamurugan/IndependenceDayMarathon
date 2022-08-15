package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Content extends BaseClass {
	
@BeforeTest
	public void excelName() {
	excelName="SaleForceChatterQuestion";
	}
	
@BeforeTest
public void browserName() {
	browserName="chrome";
}
@Test(dataProvider = "data")
	public void contents(String questions, String details) {
//	03) Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
//	04) Click View All
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
//	05) Type Content on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");
//	06) Click Content Link
		driver.findElement(By.xpath("//mark[text()='Content']/ancestor::p")).click();
//	07) Click on Chatter Tab
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']/ancestor::a"));
		driver.executeScript("arguments[0].click();", chatter);
//	08) Verify Chatter title on the page
		String title = driver.getTitle();
		System.out.println("The title of the current page is: "+title);
//	09) Click Question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();
//	10) Type Question with data (coming from excel)
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(questions);
//	11) Type Details with data (coming from excel)
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(details);
//	12) Click Ask
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
//	13) Confirm the question appears
		String question = driver.findElement(By.xpath("(//span[text()='Akshaya Balamurugan']/following::span)[3]")).getText();
		if (question.equalsIgnoreCase(questions)) {
			System.out.println("The question appears successfully");
		}
}
}