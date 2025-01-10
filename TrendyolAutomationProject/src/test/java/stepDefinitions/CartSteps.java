package stepDefinitions;

import org.openqa.selenium.By;
import pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CartSteps {

    WebDriver driver = new ChromeDriver();
    CartPage cartPage;

    @When("User adds the product to the cart")
    public void addProductToCart() {
        driver.get("https://www.trendyol.com");
        driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();
        cartPage = new CartPage(driver);
    }

    @Then("Cart price must be correct")
    public void verifyCartTotalPrice() {
        String totalPrice = cartPage.getTotalPrice();
        assertEquals("4550 TL", totalPrice);
        driver.quit();
    }

    @Then("User removes item from cart")
    public void removeProductFromCart() {
        cartPage.removeProductFromCart(0);
        assertEquals(0, cartPage.getCartItemCount());
    }
}
