package Parent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parent {

	public Properties prop;
	public static WebDriver driver;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		File file = new File("src\\main\\java\\Datas\\Datas.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions popupNotificationBlock = new ChromeOptions();
		popupNotificationBlock.addArguments("--disable-notifications");
		driver = new ChromeDriver(popupNotificationBlock);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static void cookiePopUpBlock() {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cookie-popup-id"))));
		driver.findElement(By.xpath("//button[@class='ctaText i-understand-btn text-uppercase']")).click();
	}
	
	public String screenShot(String testName, WebDriver driver ) throws IOException {
		File testcase= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenShot= System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(testcase,new File(ScreenShot));
		return ScreenShot;
	}
	
	
}
