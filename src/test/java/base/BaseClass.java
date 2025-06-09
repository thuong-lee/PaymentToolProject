package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// DriverManager
public class BaseClass {

    public static WebDriver driver;

    //Khởi tạo driver
    public void setUp() {
        System.out.println("=== Setup driver ===");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://a2z.ex-integrationstd.xyz"); //Mở trang web
    }

    //Đóng driver
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
