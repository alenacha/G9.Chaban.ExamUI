package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.PageProvider;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;

public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected PageProvider pageProvider;

    @Before
    public void setUp() {

        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

    private WebDriver initDriver() {
        String browserFromProperty = System.getProperty("browser");
        if ((browserFromProperty == null) || "chrome".equalsIgnoreCase(browserFromProperty)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browserFromProperty.toLowerCase())) { // -Dbrowser=firefox
            WebDriverManager.firefoxdriver().setup();

            webDriver = new FirefoxDriver();
        } else if ("ie".equals(browserFromProperty.toLowerCase())) {
            WebDriverManager.iedriver().setup(); //zoom 100%
            webDriver = new InternetExplorerDriver(); //security level - Medium
        } else if ("safari".equalsIgnoreCase(browserFromProperty)) {
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        } else if ("edge".equalsIgnoreCase(browserFromProperty)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }
}
