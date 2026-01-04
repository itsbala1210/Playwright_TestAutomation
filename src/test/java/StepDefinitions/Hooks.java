package StepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Arrays;

public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @Before
    public void setUp() {
        log.info("...Initialization...");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setArgs(Arrays.asList("--start-maximized"))
        );
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        log.info("Execution completed successfully.");

    }
}
