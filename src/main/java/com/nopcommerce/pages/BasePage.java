package com.nopcommerce.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public static Logger log = LogManager.getLogger();
    protected WebDriverWait wait;
    private JavascriptExecutor jse;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        jse = (JavascriptExecutor) driver;
    }
    public void clearTextValue(By locator) {
        driver.findElement(locator).clear();
    }
    public void setTextValue(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }
    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }
    public void waitUntilElementBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickOnElementByJavascript(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        jse.executeScript("arguments[0].click();", element);
    }
    public void selectByVisibleText(By locator, String textValue){
        Select countryDropDown = new Select(driver.findElement(locator));
        countryDropDown.selectByVisibleText(textValue);
    }
}
