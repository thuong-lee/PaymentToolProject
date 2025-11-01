package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver); // Gọi constructor BasePage để set driver + wait
    }

    //Check the home page is opened
    public String isHomePageOpened() throws InterruptedException {
        return getText(By.id("body-box"));
    }

    public String getUsername() throws InterruptedException {
        return getText(By.xpath("//div[contains(@class,'ant-dropdown-trigger')]//span[not(@role) and not(@class)]"));
    }

    public String getLoginSuccessToastMessage() throws InterruptedException {
        return getText(By.cssSelector("div.Toastify__toast--success"));
    }

    public void closeLoginSuccessToast() throws InterruptedException {
        click(By.xpath("//button[@aria-label='close']"));
    }

    public void clickAccountDropdown() throws InterruptedException {
        click(By.xpath("//span[@role='img' and contains(@class,'anticon-caret-down')]"));
    }

    public void clickLogoutOption() throws InterruptedException {
        click(By.xpath("//li[.//span[@aria-label='logout']]"));
    }

    public void clickChangePasswordOption() throws InterruptedException {
        click(By.xpath("//li[@class='ant-dropdown-menu-item'][2]"));
    }

    public void inputCurrentPassword(String currentPassword) throws InterruptedException {
        type(By.id("oldPassword"),currentPassword);
    }

    public void inputNewPassword(String newPassword) throws InterruptedException {
        type(By.id("newPassword"),newPassword);
    }

    public void inputConfirmNewPassword(String confirmNewPassword) throws InterruptedException {
        type(By.id("cpassword"),confirmNewPassword);
    }

    public void clickChangePassword() throws InterruptedException {
        click(By.xpath("//*[@type='submit']"));
    }

    public String getCurrentPasswordErrorMessage() throws InterruptedException {
        return getText(By.id("oldPassword_help"));
    }

    public String getNewPasswordErrorMessage() throws InterruptedException {
        return getText(By.id("newPassword_help"));
    }

    public String getConfirmNewPasswordErrorMessage() throws InterruptedException {
        return getText(By.id("cpassword_help"));
    }

    public String getToken(){
        return getLocalStorageItem("TOKEN");
    }
}

