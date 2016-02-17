package shouty;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class SeleniumShopper implements Shopper {
	
	private final WebDriver browser;
	
	@Autowired
	public SeleniumShopper(WebDriver browser) {
		this.browser = browser;
	}

	@Override
	public void setShoppingList(List<ShoppingListItem> shoppingList) {
	}

	@Override
	public List<ShoppingListItem> getShoppingList() {
		browser.get("http://localhost:9988/");
		return browser.findElements(By.cssSelector("tbody tr")).stream().map(tr -> {
			ShoppingListItem shoppingListItem = new ShoppingListItem();
			shoppingListItem.item = tr.findElement(By.cssSelector("td:first-child")).getText();
			shoppingListItem.amount = Integer.parseInt(tr.findElement(By.cssSelector("td:last-child")).getText());
			return shoppingListItem;
		}).collect(Collectors.toList());
	}
	
}
