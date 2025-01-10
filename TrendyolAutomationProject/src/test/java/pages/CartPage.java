package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Cart Items
    private final By cartItems = By.cssSelector(".pb-merchant-group");
    private final By totalPrice = By.cssSelector(".pb-summary-total-price");

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void removeProductFromCart(int index) {
        driver.findElements(cartItems).get(index).findElement(By.cssSelector(".checkout-saving-remove-button")).click();
    }
}
