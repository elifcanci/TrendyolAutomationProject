package tests;

import pages.CartPage;
import pages.ProductPage;
import pages.HomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class CartTest {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    ProductPage productPage;
    CartPage cartPage;

    @When("User adds the product to the cart")
    public void addProductToCart() {
        driver.get("https://www.trendyol.com");
        homePage.searchForProduct("Kablosuz kulaklık");
        driver.findElement(By.xpath("//h3[@class=\"prdct-desc-cntnr-ttl-w\"]")).click();
        productPage = new ProductPage(driver);
        driver.findElement(By.cssSelector(".add-to-basket-button-text")).click();
        cartPage = new CartPage(driver);
    }

    @Then("Cart price must be correct")
    public void verifyCartTotalPrice() {
        String totalPrice = cartPage.getTotalPrice();
        assertEquals("4550 tl", totalPrice);
    }

    @Then("An item must be removed from the cart")
    public void removeProductFromCart() {
        int itemCountBefore = cartPage.getCartItemCount();
        cartPage.removeProductFromCart(0);
        int itemCountAfter = cartPage.getCartItemCount();
        assertEquals(itemCountBefore - 1, itemCountAfter);
    }
}
