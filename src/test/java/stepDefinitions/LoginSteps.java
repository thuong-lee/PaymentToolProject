package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;


public class LoginSteps extends BaseClass{
    LoginPage loginPage;
//    HomePage homePage;

    public LoginSteps() {
        loginPage = new LoginPage(BaseClass.getDriver());
//        homePage = new HomePage(BaseClass.getDriver());
    }

    @Given("the user is on the login screen")
    public void theUserIsOnTheLoginScreen() {
        Assert.assertTrue(loginPage.isLoginScreenOpened(),"The Login screen failed to load");
    }

    @When("input the username {string}")
    public void inputTheUsername(String username) {

    }

    @And("input the password {string}")
    public void inputThePassword(String arg0) {
    }

    @And("input the OTP {string}")
    public void inputTheOTP(String arg0) {
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
    }

    @Then("the user should see the success popup with content {string}")
    public void theUserShouldSeeTheSuccessPopupWithContent(String arg0) {
    }

    @And("the user should see the homepage")
    public void theUserShouldSeeTheHomepage() {
    }

    @Then("the user should see the error popup with content {string}")
    public void theUserShouldSeeTheErrorPopupWithContent(String arg0) {
    }

    @When("the user enters the username {string}")
    public void theUserEntersTheUsername(String arg0) {
    }

    @And("the user enters the password {string}")
    public void theUserEntersThePassword(String arg0) {
    }

    @And("the click on the show password icon")
    public void theClickOnTheShowPasswordIcon() {
    }

    @Then("the user should see the password {string}")
    public void theUserShouldSeeThePassword(String arg0) {
    }

    @And("click on the send OTP button")
    public void clickOnTheSendOTPButton() {
    }
}
