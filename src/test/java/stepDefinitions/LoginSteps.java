package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;


public class LoginSteps extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    public LoginSteps() {
        loginPage = new LoginPage(BaseClass.getDriver());
        homePage = new HomePage(BaseClass.getDriver());
    }

    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageOpened(), "The login page failed to load");
    }

    @When("Input username {string}")
    public void inputUsername(String username) throws InterruptedException {
        loginPage.inputUsername(username);
    }

    @And("Input password {string}")
    public void inputPassword(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }

    @And("Click Send OTP button")
    public void clickSendOTPButton() throws InterruptedException {
        loginPage.clickSendOTP();
    }

    @And("Input OTP {string}")
    public void inputOTP(String otp) throws InterruptedException {
        loginPage.inputOTP(otp);
    }

    @And("Click Login button")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickLogin();
    }

    @Then("Display success toast {string}")
    public void displaySuccessToast(String toastMessage) throws InterruptedException {
        String actualToastMessage = homePage.getLoginSuccessToastMessage();
        System.out.println(actualToastMessage);
        Assert.assertEquals(actualToastMessage,toastMessage,"Toast message is incorrect");
    }

    @And("Navigate to Home page {string}")
    public void navigateToHomePageAndDisplayUsername(String title) throws InterruptedException {
        Assert.assertEquals(homePage.isHomePageOpened(),title,"Home page failed to load");
    }

    @And("Display correct username {string}")
    public void displayCorrectUsername(String username) throws InterruptedException {
        String actualUsername = homePage.getUsername();
        System.out.println(actualUsername);
        Assert.assertEquals(actualUsername,username,"User is wrong");
    }

    @Then("Display error message below username {string}")
    public void displayErrorMessageBelowUsername(String errorMessage) throws InterruptedException {
        String actualErrorMessage = loginPage.getUsernameErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,errorMessage, "Error message is incorrect");
    }

    @Then("Display error message below password {string}")
    public void displayErrorMessageBelowPassword(String errorMessage) throws InterruptedException {
        String actualErrorMessage = loginPage.getPasswordErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,errorMessage, "Error message is incorrect");
    }

    @Then("Display error message below OTP {string}")
    public void displayErrorMessageBelowOTP(String errorMessage) throws InterruptedException {
        String actualErrorMessage = loginPage.getOTPErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage,errorMessage, "Error message is incorrect");
    }

    @Then("Display error toast {string}")
    public void displayErrorToast(String toastMessage) throws InterruptedException {
        String actualToastMessage = loginPage.getLoginErrorToastMessage();
        System.out.println(actualToastMessage);
        Assert.assertEquals(actualToastMessage,toastMessage,"Toast message is incorrect");

    }

    @And("Send OTP to user's telegram ID")
    public void sendOTPToUserSTelegramID() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}