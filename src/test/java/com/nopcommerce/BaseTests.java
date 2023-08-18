package com.nopcommerce;
import com.google.common.io.Files;
import com.nopcommerce.pages.HomePage;
import com.nopcommerce.utils.LoadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static com.nopcommerce.utils.Utils.getCurrentDateTime;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;
 public static Logger log = LogManager.getLogger();

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setup(String browser) throws Exception {
        log.info("Browser Setup Based On Browser Value From testng.xml File");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            driver = new ChromeDriver(getChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else {
            throw new Exception("Browser name doesn't exist in testng.xml or it's not support");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(LoadProperties.envProperties.getProperty("implicit-timeout"))));
        goHome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        log.info("Browser initialized successfully");
    }

    @BeforeMethod
    public void goHome(){
        log.info("Load env url from env.properties file");
        String baseUrl = LoadProperties.envProperties.getProperty("url");
        driver.get(baseUrl);
    }
    @AfterClass
    public void tearDown(){
        log.info("Closing browser");
        driver.quit();
        log.info("Browser closed successfully");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result){
        log.info("Taking a screenshot for the failed test");
        String dateTime = getCurrentDateTime();
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File(".\\screenshots\\" + result.getName() + dateTime + ".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("headless=new");
        return chromeOptions;
    }
}
