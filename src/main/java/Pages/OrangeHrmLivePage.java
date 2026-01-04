package Pages;

import Utilities.EncryptionUtil;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class OrangeHrmLivePage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(OrangeHrmLivePage.class);
    private Locator usernameField;
    private Locator passwordField;
    private Locator loginBtn;

    public OrangeHrmLivePage(Page page) {
        super(page);
        this.usernameField = page.locator("//*[@placeholder='Username']");
        this.passwordField = page.locator("//*[@placeholder='Password']");
        this.loginBtn = page.locator("//*[@type='submit']");
    }

    public void loginCredentials(String username, String password) {
        page.waitForLoadState();
        usernameField.fill(EncryptionUtil.decodeKey(getProperty(username)));
        passwordField.fill(EncryptionUtil.decodeKey(getProperty(password)));
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public void verifyDashboardPage() {
        String title = page.locator("//h6[text()='Dashboard']").textContent();
        log.info("Title: {}", title);
        Assert.assertEquals(title, "Dashboard", "Title Doesn't Match");
    }
}
