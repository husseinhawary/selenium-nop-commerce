package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BooksPage extends BasePage{

    // Locators
    private By sortBooksSelect = By.id("products-orderby");
    private By addToCartBtns = By.xpath("//button[text()='Add to cart']");
    private By addItemToCartSuccessMsg = By.xpath("//p[@class='content']");
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sort books by 'Price: Low to High' step...")
    public BooksPage sortBooksByPriceFromLowToHigh() throws InterruptedException {
        log.info("Sort books by Price: Low to High");
        Select sortBookDropDown = new Select(driver.findElement(sortBooksSelect));
        sortBookDropDown.selectByVisibleText("Price: Low to High");
        // This line need to be revisited, it's not recommended, but I use it for now to overcome on quick execution
        Thread.sleep(2000);
        return this;
    }
    @Step("Add book to cart by bookIndex: {0} for method: {method} step...")
    public BooksPage addBookToCartByIndex(int bookIndex){
        log.info("Add book to cart based on index");
        waitUntilElementBeVisible(addToCartBtns);
        WebElement item =  driver.findElements(addToCartBtns).get(bookIndex);
        clickOnElementByJavascript(item);
        return this;
    }
    @Step("Get success message after adding item to cart step...")
    public String getAddItemToCartSuccessMessage(){
        log.info("Get success message after adding item to cart");
        waitUntilElementBeVisible(addItemToCartSuccessMsg);
        return getElementText(addItemToCartSuccessMsg);
    }
}
