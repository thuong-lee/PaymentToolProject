package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.*;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

//Mở DevTools → vào Local Storage
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Constructor
    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void click(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        sleep(500);
    }

    public void type(By locator, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        sleep(500);
    }

    public String getText(By locator) throws InterruptedException {
        sleep(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public boolean isDisplayed(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getLink(By locator, String attributeName) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getDomAttribute(attributeName);
    }

    // Xoá một key bất kỳ trong local storage
    public void clearLocalStorageItem(String key) {
       js.executeScript(String.format("window.localStorage.removeItem('%s');", key));
    }

    // Xoá tất cả local storage
    public void clearAllLocalStorage() {
       js.executeScript("window.localStorage.clear();");
    }

    // Lấy giá trị của key từ local storage
    // Vì JS có thể trả về object hoặc bất kỳ kiểu gì mà mình biết nó là String nên ép nó về String (String)
    //String.format là để điền cái biến key vào cái js code kia với kiểu String
    public String getLocalStorageItem(String key) {
        return (String) js.executeScript(String.format("return window.localStorage.getItem('%s');", key));
    }

    // Set giá trị cho key trong local storage
    public void setLocalStorageItem(String key, String value) {
     js.executeScript(String.format("window.localStorage.setItem('%s','%s');", key, value));
    }
}
