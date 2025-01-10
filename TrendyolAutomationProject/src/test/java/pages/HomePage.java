package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By searchBox = By.cssSelector(".V8wbcUhU");
    private final By searchButton = By.cssSelector(".cyrzo7gC]");
    private final By searchResults = By.cssSelector(".dscrptn");

    public void searchForProduct(String product) {
        WebElement searchField = driver.findElement(searchBox);
        searchField.sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public boolean isKeywordInResults(String keyword) {
        return driver.findElement(searchResults).getText().contains(keyword);
    }
}
