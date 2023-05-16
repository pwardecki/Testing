package Service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    private static WebDriver driver;
    static String browser = "EDGE";

    private Driver() {this.browser = browser;}

    public static WebDriver getDriver() {
        if(driver==null) {
            driver = getBrowser(browser);
        }
        return driver;
    }

    private static WebDriver getBrowser(String browser) {
        switch(browser) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                ChromeOptions ChOptions = new ChromeOptions();
                ChOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(ChOptions);
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver.exe");
                FirefoxOptions FFoptions = new FirefoxOptions()
                        .setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                return new FirefoxDriver(FFoptions);
            case "EDGE":
                System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unknown browser type");
        }
    }

    public static void disposeDriver() {
        if(browser != "FIREFOX") {
            driver.close();
        }
        driver.quit();
        driver = null;
    }

    public static void setInitialConfiguration() {
        driver.manage().window().maximize();
    }

    public static void navigateToPage(String url) {
        driver.navigate().to(url);
    }
}
