package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Check the login screen is opened
    public boolean isLoginScreenOpened() {
        return isDisplayed(By.id("basic_username"));
    }

    public void inputUsername(){

    }
}
