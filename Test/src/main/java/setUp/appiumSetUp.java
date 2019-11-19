package setUp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class appiumSetUp {
	private static WebDriver driver = null;

	@Before
	public void setup() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("VERSION", "8.0");
		capabilities.setCapability("deviceName", "Moto G5S Plus");
		capabilities.setCapability("udid", "ZY322C2GXS");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.poqstudio.app.platform.missguided");
		capabilities.setCapability("appActivity", "com.poqstudio.app.client.view.splash.MissguidedSplashActivity");
		capabilities.setCapability("noReste", "true");

		try {
			driver = (AndroidDriver<MobileElement>) new AndroidDriver<MobileElement>(
					new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@After
	public void cleanUp() {
		driver.quit();
	}

}
