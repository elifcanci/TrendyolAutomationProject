package tests;

import pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class SearchTest {

    WebDriver driver = new ChromeDriver();
    HomePage homePage;

    @When("User searches for {string}")
    public void searchForProduct(String product) {
        driver.get("https://www.trendyol.com");
        homePage = new HomePage(driver);
        homePage.searchForProduct(product);
    }

    @Then("Search results must include {string}")
    public void verifySearchResults(String keyword) {
        assertTrue(homePage.isKeywordInResults(keyword));
    }
}
