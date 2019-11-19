package step_definitions;

import cucumber.api.java.en.When;
import pages.BasePage;


public class shoppingBagSteps implements BasePage{
	
	@When("I select the shopping bag")
	public void selectShoppingCart() throws Exception {
		ShoppingBagPage.clickShoppingBag();
	}

	@When("I tap on the checkout to make payment")
	public void checkout() {
		ShoppingBagPage.clickCheckout();
	}

	@When("I should be displayed SignIn and Register screen")
	public void signInRegister() {
		ShoppingBagPage.validatesignInRegisterPage();
	}
}
