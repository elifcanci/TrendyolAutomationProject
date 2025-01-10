package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class SearchSteps {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);

    @Given("User goes to Trendyol home page")
    public void goToHomePage() {
        driver.get("https://www.trendyol.com");
        driver.manage().window().maximize();
        WebElement closeCookie = driver.findElement(By.xpath("//button[@id=\"onetrust-reject-all-handler\"]"));
        closeCookie.click();
    }

    @Then("User searches for {string}")
    public void searchForProduct(String product) {
        homePage.searchForProduct(product);
    }

    @Then("Search results must contain {string}")
    public void verifySearchResults(String keyword) {
        assertTrue(homePage.isKeywordInResults(keyword));
        driver.quit();
    }
}

