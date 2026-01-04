package StepDefinitions;

import Pages.OrangeHrmLivePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHrmLiveStepDefinitions {
    private final OrangeHrmLivePage orangeHrmLivePage;

    public OrangeHrmLiveStepDefinitions(Hooks hooks) {
        orangeHrmLivePage = new OrangeHrmLivePage(hooks.page);
    }

    @Given("user launch url in the browser {string}")
    public void userLaunchUrlInTheBrowser(String url) {
        orangeHrmLivePage.launchUrl(url);
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        orangeHrmLivePage.loginCredentials(username, password);
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        orangeHrmLivePage.clickLoginButton();
    }

    @Then("verify title of the page")
    public void verifyTitleOfThePage() {
        orangeHrmLivePage.getPageTitle();
    }

    @Then("verify the dashboard of the page")
    public void verifyTheDashboardOfThePage() {
        orangeHrmLivePage.verifyDashboardPage();
    }

}
