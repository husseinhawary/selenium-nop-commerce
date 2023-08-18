package com.nopcommerce.pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    // Locators V2
    private By registerLink = By.xpath("//div[@class='header-links']//a[text()='Register']");
    private By loginLink = By.xpath("//div[@class='header-links']//a[text()='Log in']");
    private By logoutLink = By.xpath("//div[@class='header-links']//a[text()='Log out']");
    private By booksLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']");
    private By closeSuccessMsg = By.xpath("//span[@class='close']");
    private By shoppingCartLink = By.xpath("//li[@id='topcartlink']//span[text()='Shopping cart']");

    public HomePage(WebDriver driver){
        super(driver);
    }
    @Step("Open register page step...")
    public RegisterPage openRegisterPage(){
        log.info("Open register page");
        waitUntilElementBeVisible(registerLink);
        clickElement(registerLink);
        return new RegisterPage(driver);
    }
    @Step("Open login page step...")
    public LoginPage openLoginPage(){
        log.info("Open register page");
        waitUntilElementBeVisible(loginLink);
        clickElement(loginLink);
        return new LoginPage(driver);
    }
    @Step("Get logout text step...")
    public String getLogoutLinkText(){
        log.info("Get logout link text");
        waitUntilElementBeVisible(logoutLink);
        return getElementText(logoutLink);
    }
    @Step("Open books page step...")
    public BooksPage openBooksPage(){
        log.info("Open books page");
        waitUntilElementBeVisible(booksLink);
        clickElement(booksLink);
        return new BooksPage(driver);
    }
    @Step("Open cart page step...")
    public CartPage openCartPage(){
        log.info("Open cart page");
        clickElement(closeSuccessMsg);
        waitUntilElementBeVisible(shoppingCartLink);
        clickOnElementByJavascript(driver.findElement(shoppingCartLink));
//        clickElement(shoppingCartLink);
        return new CartPage(driver);
    }
}
