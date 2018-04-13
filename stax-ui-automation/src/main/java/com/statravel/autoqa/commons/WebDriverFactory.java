package com.statravel.autoqa.commons;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.browser.Browser;
import com.statravel.autoqa.domain.browser.FirefoxBrowser;
import com.statravel.autoqa.domain.enumeration.Browsers;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
@Scope("prototype")
public final class WebDriverFactory {

    private static final Logger LOGGER = Logger.getLogger(WebDriverFactory.class);

    private static final String SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE = "Not able to retrieve the web driver session";

    private static final String COULD_NOT_CONNECT_TO_REMOTE_WEBDRIVER = "Could not connect to Remote Webdrive";

    private static WebDriver webDriver;

    /**
     * 
     */
    private WebDriverFactory() {

    }

    /**
     * 
     * @return WebDriver instance
     */
    public static WebDriver initWebDriver() {

        String browser = System.getProperty("browser");

        URL seleniumHostURL = null;

        try {

            seleniumHostURL = new URL(ApplicationProperties.getHost());

        } catch (MalformedURLException mue) {

            LOGGER.error(COULD_NOT_CONNECT_TO_REMOTE_WEBDRIVER, mue);

        }

        if (webDriver == null || !isSessionActive()) {

            if (browser.equalsIgnoreCase(Browsers.FIREFOX.toString())) {

                Browser firefox = new FirefoxBrowser();

                webDriver = new RemoteWebDriver(seleniumHostURL, firefox.getCapabilities());

            }
        }

        webDriver.manage()
                 .window()
                 .maximize();

        return webDriver;

    }

    /**
     * @return the webDriver
     */
    public static WebDriver getWebDriver() {

        return webDriver;
    }

    /**
     * Checks if the session is active.
     * 
     * @return true if the session is active, false otherwise
     */
    private static boolean isSessionActive() {

        try {
            return webDriver.findElements(By.tagName("body"))
                            .size() > 0;

        } catch (Exception ex) {

            LOGGER.error(SESSION_NOT_REACHABLE_EXCEPTION_MESSAGE, ex);
            return false;
        }

    }

    /**
     * Shuts down the WebDriver.
     * 
     * @throws InterruptedException
     */
    public static void quitWebDriver() {

        if (webDriver == null) {
            return;
        }
        webDriver.quit();
        webDriver = null;
    }

}
