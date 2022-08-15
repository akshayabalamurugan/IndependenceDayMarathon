package marathon3;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.DataFromExcel;

public class BaseClass {
	
	RemoteWebDriver driver;
	String browserName="";
	ChromeOptions options;
	EdgeOptions edgeOptions;
	WebDriverWait wait;
	String excelName="";
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void loginSaleforceChrome(String url, String username, String password) {
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			options= new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver= new ChromeDriver(options);
		}
		
		else {
			WebDriverManager.edgedriver().setup();
			edgeOptions= new EdgeOptions();
			edgeOptions.addArguments("--disable-notifications");
			driver= new EdgeDriver(edgeOptions);
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}
	
	@DataProvider(name="data")
	public String[][] dataset() throws IOException {
		String[][] data= DataFromExcel.readData(excelName);
		return data;
	}
	
	@AfterMethod
	public void tearDOM() {
		driver.quit();
	}
}
