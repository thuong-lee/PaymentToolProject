package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class ChangePasswordSteps extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    public ChangePasswordSteps() {
        loginPage = new LoginPage(BaseClass.getDriver());
        homePage = new HomePage(BaseClass.getDriver());
    }

    @Given("User is logged in with username {string}, password {string}, and otp {string}")
    public void userIsLoggedInWithUsernamePasswordAndOtp(String username, String password, String otp) throws InterruptedException {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.inputOTP(otp);
        loginPage.clickLogin();
    }

    @When("User clicks on account dropdown")
    public void userClicksOnAccountDropdown() throws InterruptedException {
        homePage.closeLoginSuccessToast();
        homePage.clickAccountDropdown();
    }

    @And("User selects Change Password option")
    public void userSelectsChangePasswordOption() throws InterruptedException {
        homePage.clickChangePasswordOption();
    }

    @And("User inputs Current Password {string}")
    public void userInputsCurrentPassword(String currentPassword) throws InterruptedException {
        homePage.inputCurrentPassword(currentPassword);
    }

    @And("User inputs New Password {string}")
    public void userInputsNewPassword(String newPassword) throws InterruptedException {
        homePage.inputNewPassword(newPassword);
    }

    @And("User inputs Confirm New Password {string}")
    public void userInputsConfirmNewPassword(String confirmNewPassword) throws InterruptedException {
        homePage.inputConfirmNewPassword(confirmNewPassword);
    }

    @And("User clicks Change Password button")
    public void userClicksChangePasswordButton() throws InterruptedException {
        homePage.clickChangePassword();
    }

    @Then("Display error message below Current Password {string}")
    public void displayErrorMessageBelowCurrentPassword(String errorMessage) throws InterruptedException {
        String actualErrorMessage = homePage.getCurrentPasswordErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, errorMessage, "Error message does not match");
    }

    @Then("Display error message below New Password {string}")
    public void displayErrorMessageBelowNewPassword(String errorMessage) throws InterruptedException {
        String actualErrorMessage = homePage.getNewPasswordErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, errorMessage, "Error message does not match");
    }

    @And("Display error message below Confirm New Password {string}")
    public void displayErrorMessageBelowConfirmNewPassword(String errorMessage) throws InterruptedException {
        String actualErrorMessage = homePage.getConfirmNewPasswordErrorMessage();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(actualErrorMessage, errorMessage, "Error message does not match");
    }

    @And("User logs out")
    public void userLogsOut() {
        Assert.assertTrue(loginPage.isLoginPageOpened(), "The login page failed to load");
    }

    @And("User logs in again with username {string}, password {string}, and otp {string}")
    public void userLogsInAgainWithUsernamePasswordAndOtp(String username, String password, String otp) throws InterruptedException {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.inputOTP(otp);
        loginPage.clickLogin();
    }

    @Then("Display Home page {string}")
    public void displayHomePage(String title) throws InterruptedException {
        Assert.assertEquals(homePage.isHomePageOpened(), title, "Home page failed to load");
    }

    @Then("Display change password success toast {string}")
    public void displayChangePasswordSuccessToast(String toastMessage) throws InterruptedException {
        String actualMessage = loginPage.getChangePasswordSuccessToast();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,toastMessage,"Toast message is incorrect");
    }

    @And("User selects Logout option")
    public void userSelectsLogoutOption() throws InterruptedException {
        homePage.clickLogoutOption();
    }

    @Then("Navigate to Login page")
    public void navigateToLoginPage() {
    loginPage.isLoginPageOpened();
    }

    @And("Clear token from Local Storage")
    public void isTokenClearedAfterLogout() {
        Assert.assertNull(homePage.getToken(),"Token is not removed");
    }
}
