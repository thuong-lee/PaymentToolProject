package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Check the login page is opened
    public boolean isLoginPageOpened() {
        return isDisplayed(By.id("basic_username"));
    }

    public void inputUsername(String username) throws InterruptedException {
        type(By.id("basic_username"), username);
    }

    public void inputPassword(String password) throws InterruptedException {
        type(By.id("basic_password"), password);
    }

    public void clickSendOTP() throws InterruptedException {
        click(By.xpath("//button[span[text()='Send OTP']]"));
    }

    public void inputOTP(String otp) throws InterruptedException {
        type(By.id("basic_otp"),otp);
    }

    public void clickLogin() throws InterruptedException {
        click(By.xpath("//button[span[text()='Login']]"));
    }

    public String getUsernameErrorMessage() throws InterruptedException {
       return getText(By.xpath("//*[@id=\"basic_username_help\"]/div"));
    }

    public String getPasswordErrorMessage() throws InterruptedException {
        return getText(By.xpath("//*[@id=\"basic_password_help\"]/div"));
    }
    public String getOTPErrorMessage() throws InterruptedException {
        return getText(By.xpath("//*[@id=\"basic\"]/div[3]/div[1]/div/div[2]/div/div"));
    }

    public String getLoginErrorToastMessage() throws InterruptedException {
        return getText(By.xpath("//*[@role='alert']"));
    }

    public String getChangePasswordSuccessToast() throws InterruptedException {
        return getText(By.className("ant-message-notice-content"));
    }
}
