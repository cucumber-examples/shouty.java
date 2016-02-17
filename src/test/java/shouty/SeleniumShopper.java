package shouty;

import java.util.List;

public class SeleniumShopper implements Shopper {

	@Override
	public void setShoppingList(List<ShoppingListItem> shoppingList) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ShoppingListItem> getShoppingList() {
		throw new UnsupportedOperationException();
	}

}
