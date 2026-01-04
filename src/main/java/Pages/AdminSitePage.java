package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class AdminSitePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(AdminSitePage.class);
    private Locator adminTab;
    private Locator addAdminBtn;
    private Locator userRole;
    private Locator userNameField;
    private Locator userName;
    private Locator userPasswordField;
    private Locator confirmPasswordField;
    private Locator saveBtn;
    private Locator searchBtn;
    private Locator deleteUser;
    private Locator deleteUserBtn;

    public AdminSitePage(Page page) {
        super(page);
        this.adminTab = page.locator("//span[text()='Admin']");
        this.addAdminBtn = page.locator("//button[normalize-space()='Add']");
        this.userRole = page.locator("(//*[contains(text(),'-- Select --')])[1]");
        this.userNameField = page.getByPlaceholder("Type for hints...");
        this.userName = page.locator("(//*[@class='oxd-input oxd-input--active'])[2]");
        this.userPasswordField = page.locator("(//input[@type='password'])[1]");
        this.confirmPasswordField = page.locator("(//input[@type='password'])[2]");
        this.saveBtn = page.locator("//*[text()=' Save ']");
        this.searchBtn = page.locator("//button[text()=' Search ']");
        this.deleteUser = page.locator("//i[@class='oxd-icon bi-trash']");
        this.deleteUserBtn = page.locator("//*[text()=' Yes, Delete ']");
    }

    public void adminMenu() {
        adminTab.click();
        log.info("Admin Tab click successfully...");
    }

    public void addAdminBtn() {
        page.waitForLoadState();
        addAdminBtn.click();
    }

    public void userRole(String userOption) {
        userRole.click();
        Locator userOptions = page.locator("//*[contains(text(),'" + userOption + "')]");
        userOptions.click();
    }

    public void userName(String employeeName) {
        userNameField.waitFor(new Locator.WaitForOptions().setTimeout(3000));
        userNameField.fill(employeeName);
        Locator userNameOption = page.locator("//*[text()='" + employeeName + "']");
        userNameOption.waitFor(new Locator.WaitForOptions().setTimeout(3000));
        userNameOption.click();
    }

    public void status(String statusOption) {
        userRole.waitFor(new Locator.WaitForOptions().setTimeout(3000));
        userRole.click();
        Locator statusOptions = page.locator("(//*[contains(text(),'" + statusOption + "')])[1]");
        statusOptions.waitFor(new Locator.WaitForOptions().setTimeout(1000));
        statusOptions.click();
    }

    public void addUsername(String addUsername) {
        userName.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        userName.fill(addUsername);
    }

    public void enterPasswordAndConfirm(String userPassword, String confirmPassword) {
        userPasswordField.fill(userPassword);
        sleep(2);
        confirmPasswordField.fill(confirmPassword);
    }

    public void saveBtn() {
        executeJavascript(saveBtn);
        sleep(5);
        log.info("Saved successfully...");
    }

    public void searchBtn() {
        isElementClickable(searchBtn, 3);
        executeJavascript(searchBtn);
        log.info("Search button clicked successfully...");
        sleep(3);
    }

    public void verifyUserData(String username) {
        SoftAssert sa = new SoftAssert();
        Locator userData = page.locator("//*[text()='" + username + "']");
        isElementDisplayed(userData);
        log.info("User data verified successfully...");
        sa.assertAll();
    }

    public void deleteUserData() {
        page.waitForLoadState();
        deleteUser.click();
        isElementDisplayed(deleteUserBtn);
        deleteUserBtn.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        deleteUserBtn.click();
        sleep(3);
        log.info("User deleted in admin page...");
    }
}
