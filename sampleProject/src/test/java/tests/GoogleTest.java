package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.iedriver().arch32().setup(); // By default WebDriverManager arch32() is using
		// IEDriverServer version 3.15.0. Its working with IE 11
		// version
		WebDriverManager.iedriver().arch32().version("3.14.0").setup();
		InternetExplorerOptions IEoptions = new InternetExplorerOptions();
		IEoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		IEoptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		IEoptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		IEoptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
		IEoptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		IEoptions.setCapability("browser.helperApps.alwaysAsk.force", false);
		IEoptions.setCapability("browser.download.manager.alertOnEXEOpen", false);
		IEoptions.setCapability("browser.download.manager.focusWhenStarting", false);
		IEoptions.setCapability("browser.download.manager.useWindow", false);
		IEoptions.setCapability("browser.download.manager.showAlertOnComplete", false);
		driver = new InternetExplorerDriver(IEoptions);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		System.out.println(" application launched successfully");
		
		driver.findElement(By.name("q")).sendKeys("This is a test search");
		driver.findElement(By.name("btnK")).click();
		
	}
}
