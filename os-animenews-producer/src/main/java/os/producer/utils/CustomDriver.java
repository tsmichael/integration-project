package os.producer.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomDriver {

    private static CustomDriver instance = null;

    private static WebDriver webDriver;

    private CustomDriver() {
    }

    public static CustomDriver initDriver() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver.exe");
            instance = new CustomDriver();
            //WebDriverManager.chromedriver().setup();

            webDriver = new ChromeDriver();

            webDriver.manage().window().maximize();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            instance = null;
        }
    }
}
