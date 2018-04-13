package com.statravel.autoqa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class ApplicationProperties {

    private static String host;
    private static String usBaseURL;
    private static String ukBaseURL;
    private static String auBaseURL;
    private static String nzBaseURL;

    /**
     * 
     */
    public ApplicationProperties() {

    }

    /**
     * @return the host
     */
    public static String getHost() {
        return host;
    }

    /**
     * @param host
     *            the host to set
     */
    @Value("${selenium.host}")
    public void setHost(final String host) {
        ApplicationProperties.host = host;
    }

    /**
     * @return the usBaseURL
     */
    public static String getUsBaseURL() {
        return usBaseURL;
    }

    /**
     * @param usBaseURL
     *            the usBaseURL to set
     */
    @Value("${us.base.url}")
    public void setUsBaseURL(String usBaseURL) {
        ApplicationProperties.usBaseURL = usBaseURL;
    }

    /**
     * @return the ukBaseURL
     */
    public static String getUkBaseURL() {
        return ukBaseURL;
    }

    /**
     * @param ukBaseURL
     *            the ukBaseURL to set
     */
    @Value("${uk.base.url}")
    public void setUkBaseURL(String ukBaseURL) {
        ApplicationProperties.ukBaseURL = ukBaseURL;
    }

    /**
     * @return the auBaseURL
     */
    public static String getAuBaseURL() {
        return auBaseURL;
    }

    /**
     * @param auBaseURL
     *            the auBaseURL to set
     */
    @Value("${au.base.url}")
    public void setAuBaseURL(String auBaseURL) {
        ApplicationProperties.auBaseURL = auBaseURL;
    }

    /**
     * @return the nzBaseURL
     */
    public static String getNzBaseURL() {
        return nzBaseURL;
    }

    /**
     * @param nzBaseURL
     *            the nzBaseURL to set
     */
    @Value("${nz.base.url}")
    public void setNzBaseURL(String nzBaseURL) {
        ApplicationProperties.nzBaseURL = nzBaseURL;
    }

}
