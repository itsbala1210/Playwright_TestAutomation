package StepDefinitions;

import Pages.AdminSitePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSiteStepDefinitions {
    private final AdminSitePage adminSitePage;

    public AdminSiteStepDefinitions(Hooks hooks) {
        adminSitePage = new AdminSitePage(hooks.page);
    }

    @Given("selects the admin tab in dashboard")
    public void selectsTheAdminTabInDashboard() {
        adminSitePage.adminMenu();
    }

    @Then("user click add button in admin page")
    public void userClickAddButtonInAdminPage() {
        adminSitePage.addAdminBtn();
    }

    @When("user selects the user role {string}")
    public void userSelectsTheUserRole(String userOptions) {
        adminSitePage.userRole(userOptions);
    }

    @And("takes a verified screenshot in page")
    public void takesAVerifiedScreenshotInPage() {
        adminSitePage.takeScreenshot();
    }

    @Given("enters the employee name {string}")
    public void entersTheEmployeeName(String employeeName) {
        adminSitePage.userName(employeeName);
    }

    @Then("selects the status {string}")
    public void selectsTheStatus(String statusOptions) {
        adminSitePage.status(statusOptions);
    }

    @And("user sends the username {string}")
    public void userSendsTheUsername(String addUserName) {
        adminSitePage.addUsername(addUserName);
    }

    @Then("sends the password {string} and confirm password {string}")
    public void sendsThePasswordAndConfirmPassword(String userPassword, String confirmPassword) {
        adminSitePage.enterPasswordAndConfirm(userPassword, confirmPassword);
    }

    @And("user click on save button")
    public void userClickOnSaveButton() {
        adminSitePage.saveBtn();
    }

    @And("user click on search button in admin page")
    public void userClickOnSearchButtonInAdminPage() {
        adminSitePage.searchBtn();
    }

    @Then("user verify user data {string} in admin page")
    public void userVerifyUserDataInAdminPage(String username) {
        adminSitePage.verifyUserData(username);
    }

    @Then("user deletes a user data")
    public void userDeletesAUserData() {
        adminSitePage.deleteUserData();
    }
}
