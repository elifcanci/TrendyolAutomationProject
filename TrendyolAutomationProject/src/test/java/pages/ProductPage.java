package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Product name, price and availability
    private final By productName = By.xpath("//a[@class=\"product-brand-name-with-link\"]/following-sibling::span");
    private final By productPrice = By.cssSelector(".pb-basket-item-price");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

}
