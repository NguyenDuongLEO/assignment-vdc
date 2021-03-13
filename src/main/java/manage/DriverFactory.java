package manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static Map<String, WebDriver> driverMapping = new HashMap<String, WebDriver>();

    public static WebDriver getDriver() {
        return driverMapping.get(Thread.currentThread().getName());
    }

    public static void setDriver(WebDriver driver) {
        driverMapping.put(Thread.currentThread().getName(), driver);
    }

    public static WebDriver getDriverInstance() {
        System.getProperty("user.dir");

        return new ChromeDriver();
    }
}
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://openweathermap.org/");
//        driver.manage().window().maximize();
//        driver.close();
//    }