package TestCases;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import FrameworkBase.BaseClass;
import FrameworkBase.UtilClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VerifyBanner_01 extends BaseClass {

	// Test case 1 & 3 is samwe
	@Test(priority = 1)
	public static void verifyBannerAds() throws Exception {
		System.out.println("App launched");
		Thread.sleep(20000);
		UtilClass.selectBannerAd();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		System.out.println("Landed back on app");
	}

	@Test(priority = 2)
	public static void verifyBannerAdsWithAndWithoutWifi() throws Exception {
		System.out.println("App launched");
		Thread.sleep(10000);
		System.out.println("Lets test switching the wifi on/off");

		UtilClass.WifiOff();
		System.out.println("Well done now its time to switch on wifi");
		Thread.sleep(5000);

		UtilClass.WifiOn();
		System.out.println("Well done now its time to switch off wifi");
		Thread.sleep(10000);

		UtilClass.selectBannerAd();
		Thread.sleep(20000);
		driver.navigate().back();
		Thread.sleep(10000);
		System.out.println("Landed back on app");
	}

	@Test(priority = 3)
	public static void verifyBannerAdsSwitching() throws Exception {
		System.out.println("App launched");
		Thread.sleep(20000);
		UtilClass.selectBannerAd();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		System.out.println("Landed back on app");
		Thread.sleep(20000);
		System.out.println("Lets wait for Ads to change/switch");
		Thread.sleep(20000);
		UtilClass.selectBannerAd();
		Thread.sleep(10000);
		driver.navigate().back();
	}

	@Test(priority = 4)
	public static void verifyBannerAdsOnRestartMobile() throws Throwable {
		System.out.println("App launched");
		Thread.sleep(20000);
		System.out.println("Restarting device");
		UtilClass.runMyCommand();
		//System.out.println("Lets wwait...");
		//Thread.sleep(30000);
		//System.out.println("Waited too longs");
		//System.out.println("Launch app again");
		//BaseClass.setup();
	}

}
