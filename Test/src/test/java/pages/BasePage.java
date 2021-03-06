package pages;

import Actions.actions;

public interface BasePage {

	actions userActions = new actions();
	homePage HomePage = new homePage(userActions);
	productPage ProductPage = new productPage(userActions);
	shoppingBagPage ShoppingBagPage = new shoppingBagPage(userActions);
}
