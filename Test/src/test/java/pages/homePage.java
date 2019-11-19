package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Actions.actions;

import setUp.appiumSetUp;
import utility.home;

public class homePage extends appiumSetUp {
	private WebDriver driver;
	private actions userActions;

	public homePage(actions userActions) {
		this.driver = getDriver();
		this.userActions = userActions;
	}

	public void navigateToHomePage() throws Exception {		
		userActions.waitUntilVisible();
		driver.findElement(By.id(home.startButton)).click();
		driver.findElement(By.id(home.homepage)).isDisplayed();

	}

	public void selectMenuBar() {
		driver.findElement(By.xpath(home.menuBar)).click();
		driver.findElement(By.xpath(home.menuBarClose)).isDisplayed();
	}

	public void selectOptionFromMenuBar(String option) throws Exception {
		 userActions.scrollToElement(By.xpath("productsDisplay."+option));
		 driver.findElement(By.xpath("productsDisplay."+option)).click();
	}

}
