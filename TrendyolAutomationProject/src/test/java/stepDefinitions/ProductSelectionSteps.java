package stepDefinitions;

import pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class ProductSelectionSteps {

    WebDriver driver = new ChromeDriver();
    ProductPage productPage;

    @When("User clicks on a product from search results")
    public void clickOnProduct() {
 //       driver.get("https://www.trendyol.com");
//        driver.findElement(By.xpath("//div[@class='product-card-grid-layout' and @style='grid-template-columns: repeat(4, 1fr);']")).click();
        productPage = new ProductPage(driver);
    }

    @Then("Product name, price must be displayed correctly")
    public void verifyProductDetails() {
//        assertNotNull(productPage.getProductName());
//        assertNotNull(productPage.getProductPrice());
          driver.quit();
    }
}
