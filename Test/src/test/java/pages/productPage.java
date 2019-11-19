package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Actions.actions;
import junit.framework.Assert;
import setUp.appiumSetUp;
import utility.productsDisplay;

public class productPage extends appiumSetUp {
	private WebDriver driver;
	WebElement element;
	private actions userActions;

	public productPage(actions userActions) {
		this.driver = getDriver();
		this.userActions = userActions;
	}

	public void validateProductPage(String option) {
		driver.findElement(By.xpath("productsDisplay."+option));
	}

	public void selectItem(int itemNumber) throws Exception {
		List<WebElement> elements = driver.findElements(By.id(productsDisplay.productName));
		String productName = elements.get(itemNumber).getText();
		elements.get(itemNumber).click();
		userActions.waitUntilVisible();
		driver.findElement(By.id(productsDisplay.productImageSlideBar));
		userActions.scrollToElement(By.id(productsDisplay.productInfoTitle));
		String productInfoName = driver.findElement(By.id(productsDisplay.productInfoTitle)).getText();
		Assert.assertEquals(productName, productInfoName);

	}

	public void addItemToBag() throws Exception {
		userActions.scrollToElement(By.id(productsDisplay.addToBagButton));
		driver.findElement(By.id(productsDisplay.addToBagButton)).click();
	}

	public void selectSize(String size) {
		driver.findElement(By.id(productsDisplay.selectSizePage));
		List<WebElement> elements = driver.findElements(By.id(productsDisplay.sizePicker));
		for (int i = 0; i <= elements.size(); i++) {
			if (elements.get(i).getText() == size) {
				elements.get(i).click();
			}
		}

	}

	public void validateNotifcation() {
		driver.findElement(By.id(productsDisplay.notification));
	}

}
