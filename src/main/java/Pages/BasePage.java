package Pages;

import Helper.ConfigFileReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.NoSuchElementException;


public class BasePage {
    protected Page page;
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(Page page) {
        this.page = page;
    }

    public void launchUrl(String url) {
        page.navigate(getProperty(url));
    }

    public static String getProperty(String key) {
        String value = ConfigFileReader.getInstance().getProperty(key);
        if (StringUtils.isEmpty(value)) {
            log.warn("Properties not found...{}", key);
            return key;
        }
        return value;
    }

    public void getPageTitle() {
        String title = page.title();
        log.info("Page title is: {}", title);

    }

    public void sleep(long seconds) {
        page.waitForTimeout(seconds * 1000);
    }

    public void takeScreenshot() {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("src/test/resources/Screenshots/" + page.title() + ".png"))
                .setFullPage(true));
        log.info("Screenshot taken successfully...");
    }

    public void executeJavascript(Locator locator) {
        try {
            locator.evaluate("element => element.click()");
        } catch (Exception e) {
            log.info("Element not found...", e);
        }
    }

    public void isElementClickable(Locator locator, long timeDuration) {
        locator.waitFor(new Locator.WaitForOptions().setTimeout(timeDuration * 1000).setState(WaitForSelectorState.VISIBLE));
    }

    public boolean isElementDisplayed(Locator locator) {
        try {
            return locator.isVisible();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
