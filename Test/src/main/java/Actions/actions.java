package Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import setUp.appiumSetUp;

public class actions extends appiumSetUp {
	@SuppressWarnings("rawtypes")
	PointOption pointOption = new PointOption();
	private WebDriver driver;

	public actions() {
		this.driver = getDriver();
	}

	public boolean scrollToElement(By by) throws Exception {
		boolean isFoundTheElement = driver.findElements(by).size() > 0;
		while (isFoundTheElement == false) {
			swipeVertical(0.8, 0.1, 0.5, 2000);
			isFoundTheElement = driver.findElements(by).size() > 0;
		}
		return isFoundTheElement;
	}

	public void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage, int duration)
			throws Exception {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * finalPercentage);
		getTouchAction().press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	@SuppressWarnings("rawtypes")
	public TouchAction getTouchAction() {
		return new TouchAction((MobileDriver) driver);
	}

	public void waitUntilVisible() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
