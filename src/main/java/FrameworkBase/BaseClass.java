package FrameworkBase;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public static AndroidDriver<MobileElement> driver;
	static AppiumDriverLocalService appiumService;
	static String appiumServiceUrl;
	public static WebDriverWait wait;

	// dumpsys window windows | grep -E ‘mCurrentFocus|mFocusedApp’

	@BeforeMethod
	public static void setup() throws Exception {

		// Lauching App using appium server:
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
		appiumServiceUrl = appiumService.getUrl().toString();
		System.out.println("Appium Service Address : - " + appiumServiceUrl);

		// Below are device capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "D:\\WWF Words with Friends Helper_v4_apkpure.com.apk");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("fullReset", "true");
		// caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("appPackage", "com.wwftool");
		caps.setCapability("appActivity", "com.wwftool.MainActivity");
		caps.setCapability("automationName", "UiAutomator2");

		driver = new AndroidDriver<>(new URL(appiumServiceUrl), caps);
		// driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 10);

	}

	@AfterMethod
	public void End() {
		System.out.println("Stop driver");
		driver.quit();
		System.out.println("Stop appium service");
		appiumService.stop();
	}
}
