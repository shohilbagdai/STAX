package com.statravel.autoqa.domain.browser;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author Created by STA Automation QA Team
 *
 */
public class FirefoxBrowser extends Browser {

    private static final String NAME = "Firefox";
    private static DesiredCapabilities capabilities;

    static {
        capabilities = new DesiredCapabilities();

        capabilities = DesiredCapabilities.firefox();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setVersion("52");
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("acceptSslCerts", true);
        capabilities.setCapability("rotatable", false);
        capabilities.setCapability("locationContextEnabled", true);
        capabilities.setCapability("cssSelectorsEnabled", true);
        capabilities.setCapability("databaseEnabled", true);
        capabilities.setCapability("handlesAlerts", true);
        capabilities.setCapability("nativeEvents", false);
        capabilities.setCapability("webStorageEnabled", true);
        capabilities.setCapability("applicationCacheEnabled", true);
        capabilities.setCapability("takesScreenshot", true);
    }

    /**
     * 
     */
    public FirefoxBrowser() {

        super(NAME, capabilities);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
