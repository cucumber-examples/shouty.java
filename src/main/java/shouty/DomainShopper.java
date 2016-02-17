package shouty;

import java.util.List;

public class DomainShopper implements Shopper {

	private List<ShoppingListItem> shoppingList;

	@Override
	public void setShoppingList(List<ShoppingListItem> shoppingList) {
		this.shoppingList = shoppingList;
	}

	@Override
	public List<ShoppingListItem> getShoppingList() {
		return shoppingList;
	}

}
