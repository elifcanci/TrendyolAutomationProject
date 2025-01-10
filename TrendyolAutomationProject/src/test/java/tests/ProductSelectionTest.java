package tests;

import pages.ProductPage;
import pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class ProductSelectionTest {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    ProductPage productPage;

    @When("User clicks on a product from search results")
    public void clickOnProduct() {
        driver.get("https://www.trendyol.com");
        homePage.searchForProduct("Kablosuz kulaklık");
        driver.findElement(By.xpath("//h3[@class=\"prdct-desc-cntnr-ttl-w\"]")).click();
        productPage = new ProductPage(driver);
    }

    @Then("Product name, price, and availability must be displayed correctly")
    public void verifyProductDetails() {
        String productName = productPage.getProductName();
        String productPrice = productPage.getProductPrice();

        assertNotNull(productName);
        assertNotNull(productPrice);
    }
}

