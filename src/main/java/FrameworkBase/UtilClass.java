package FrameworkBase;

import java.io.IOException;
import java.util.Scanner;

import org.testng.Assert;
import java.io.ByteArrayOutputStream;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.Executor;
import org.apache.commons.exec.PumpStreamHandler;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.offset.PointOption;

public class UtilClass extends BaseClass {

	public static void WifiOn() {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		Assert.assertTrue(state.isWiFiEnabled(), "Wifi is not switched on");
		System.out.println("WiFi turned on");
	}

	public static void WifiOff() {
		ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		Assert.assertFalse(state.isWiFiEnabled(), "Wifi is not switched off");
		System.out.println("WiFi turned off");
	}

	public static void selectBannerAd() {
		TouchAction a2;

		// For Real device
		// new TouchAction(driver).tap(PointOption.point(500,
		// 1826)).release().perform();

		// Emulator
		new TouchAction(driver).tap(PointOption.point(462, 1969)).release().perform();
	}

	public static void toggleWifi() {
		driver.toggleWifi();

	}

	public static String command(String command) {
		// Formatting ADB Command
		if (command.startsWith("adb"))
			command = command.replace("adb ", "YOURPATH/platform-tools/adb ");
		else
			throw new RuntimeException("This method is designed to run ADB commands only!");

		System.out.println("Formatted ADB Command: " + command);

		String output = command(command); // see runCommand below
		System.out.println("Output of the ADB Command: " + output);
		if (output == null)
			return "";
		else
			return output.trim();
	}

	public static void runMyCommand() throws Throwable {

		CommandLine cmd = new CommandLine("adb");
		cmd.addArgument("reboot", false).addArgument("-p", false);
		DefaultExecutor exec = new DefaultExecutor();
		exec.execute(cmd);

		/*
		 * String output = null; try { Scanner scanner = new
		 * Scanner(Runtime.getRuntime().exec(command).getInputStream()).useDelimiter(
		 * "\\A"); if (scanner.hasNext()) output = scanner.next(); } catch (IOException
		 * e) { throw new RuntimeException(e.getMessage()); } return output;
		 */
	}

}
