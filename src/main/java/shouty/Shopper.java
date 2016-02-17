package shouty;

import java.util.List;

public interface Shopper {

	void setShoppingList(List<ShoppingListItem> shoppingList);

	List<ShoppingListItem> getShoppingList();

}