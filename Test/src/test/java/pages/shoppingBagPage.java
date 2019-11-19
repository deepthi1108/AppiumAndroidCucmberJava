package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Actions.actions;
import setUp.appiumSetUp;
import utility.shoppingBag;

public class shoppingBagPage extends appiumSetUp{
	private WebDriver driver;
	private actions userActions;
	
	public shoppingBagPage(actions userActions) {
		this.driver = getDriver();
		this.userActions = userActions;
	}

	public void clickShoppingBag() throws Exception {
		driver.findElement(By.id(shoppingBag.shoppingBagIcon)).click();
		userActions.waitUntilVisible();
		driver.findElement(By.id(shoppingBag.shoppingBagHeader));
		}
	
	public void clickCheckout() {
		driver.findElement(By.id(shoppingBag.checkoutButton)).click();
	}
	
	public void validatesignInRegisterPage() {
		driver.findElement(By.id(shoppingBag.registerButton));
		driver.findElement(By.id(shoppingBag.signInButton));
	}
	
}
