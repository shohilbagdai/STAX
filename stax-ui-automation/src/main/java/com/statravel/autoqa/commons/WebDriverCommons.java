package com.statravel.autoqa.commons;

import java.io.File;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author STA Development Team
 *
 */
@Component
public class WebDriverCommons {

    @Autowired
    private Utilities utilities;

    private static final Logger LOGGER = Logger.getLogger(WebDriverCommons.class);

    private static final int WEBDRIVER_PAUSE_TIME = 50;

    public static final int TIMEOUT_FOR_HIGHLIGHT_ELEMENT = 100;

    public static final String FAILED_TO_DISPLAY_ELEMENT_MESSAGE = "Failed to display element";

    public static final String FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE = "Failed to enter given value to given element";

    public static final String FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE = "Failed to click on given element";

    public static final String FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE = "Failed to highlight element for given time";

    public static final int SIXTY_UNITS = 60;

    public static final int TEN_UNITS = 10;

    public static final int SIZE_FIVE = 5;

    public static final int TIME_OUT_IN_SECONDS = 1000;

    /**
     * Pauses the WebDriver process for a specific time.
     * 
     * @param element
     *            element to wait for
     */
    public void waitForElementToBeVisible(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), WEBDRIVER_PAUSE_TIME);

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * Highlight element with yellow colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementYellowColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid yellow;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with red colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithRedColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid red;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Highlight element with blue colour.
     * 
     * @param element
     *            element
     */
    public void getHighlightElementWithBlueColour(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid blue;');", element);

        try {
            Thread.sleep(TIMEOUT_FOR_HIGHLIGHT_ELEMENT);
        } catch (InterruptedException e) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_HIGHLIGHT_ELEMENT_FOR_GIVEN_TIME_MESSAGE, element), e);
        }

        js.executeScript("arguments[0].setAttribute('style','');", element);

    }

    /**
     * Pauses the WebDriver process for a specific time.
     * 
     */

    public void waitForPageLoaded() {

        WebDriver driver = WebDriverFactory.getWebDriver();
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                                                    .equals("complete");
            }
        };

        Wait<WebDriver> wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);

        wait.until(expectation);

    }

    /**
     * Waits for element to be clickable.
     * 
     * @param element
     *            element to wait for
     * 
     */
    public void waitForElementToBeClickable(final WebElement element) {

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), WEBDRIVER_PAUSE_TIME);

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /**
     * Scrolls the driver to the element given.
     * 
     * @param element
     *            element to scroll to
     */
    public void scrollTo(final WebElement element) {

        waitForElementToBeVisible(element);

        JavascriptExecutor jse = (JavascriptExecutor) WebDriverFactory.getWebDriver();

        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    /**
     * Scroll to bottom of the page.
     */
    public void scrollToBottom() {

        ((JavascriptExecutor) WebDriverFactory.getWebDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    /**
     * Selects and item from a drop down element.
     * 
     * @param element
     *            element to manage
     * @param text
     *            text
     */
    public void selectFromDropdown(final WebElement element, final String text) {
        scrollTo(element);

        getHighlightElementYellowColour(element);

        Select select = new Select(element);

        select.selectByVisibleText(text);

        utilities.timeInterval(1);
    }

    /**
     * Selects and item from a drop down element by index.
     * 
     * @param element
     *            element to manage
     * @param index
     *            index
     */
    public void selectValueFromDropdownByIndex(final WebElement element, final int index) {
        scrollTo(element);

        getHighlightElementWithRedColour(element);

        Select select = new Select(element);

        select.selectByIndex(index);
    }

    /**
     * 
     * @return alert
     */
    public Alert getAlertPopUp() {

        Alert alert = WebDriverFactory.getWebDriver()
                                      .switchTo()
                                      .alert();

        return alert;

    }

    /**
     * to check is element displayed or not by by.
     * 
     * @param by
     *            by
     * @return true if element display else false
     */
    public boolean isDisplayed(final By by) {

        try {

            return WebDriverFactory.getWebDriver()
                                   .findElement(by)
                                   .isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, by), nsee);
            return false;

        }
    }

    /**
     * to check is element displayed or not by element.
     * 
     * @param element
     *            element
     * @return true if element display else false
     */
    public boolean isDisplayed(final WebElement element) {

        try {
            scrollTo(element);
            getHighlightElementWithRedColour(element);
            return element.isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, element), nsee);
            return false;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
    }

    /**
     * to check is element displayed or not by element.
     * 
     * @param element
     *            element
     * @return true if element display else false
     */
    public boolean isDisplayedWithTwoSecondsWait(final WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), 2);
            wait.until(ExpectedConditions.visibilityOf(element));
            getHighlightElementWithRedColour(element);
            return element.isDisplayed();

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_DISPLAY_ELEMENT_MESSAGE, element), nsee);
            return false;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            return false;
        }
    }

    /**
     * clear value from given element.
     * 
     * @param element
     *            element
     */
    public void clear(final WebElement element) {
        scrollTo(element);
        getHighlightElementYellowColour(element);
        element.clear();
    }

    /**
     * click on given element.
     * 
     * @param element
     *            element
     */
    public void click(final WebElement element) {

        try {

            scrollTo(element);
            getHighlightElementWithBlueColour(element);

        } catch (Exception e) {
            LOGGER.info(MessageFormat.format(FAILED_TO_CLICK_ON_GIVEN_ELEMENT_MESSAGE, element), e);
        }
        element.click();
    }

    /**
     * enter value to given element.
     * 
     * @param element
     *            element
     * @param value
     *            value
     */
    public void sendKeys(final WebElement element, final String value) {

        try {

            scrollTo(element);
            clear(element);
            element.sendKeys(value);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);
        }
    }

    /**
     * enter value to given element with out deleting from that element.
     * 
     * @param element
     *            element
     * 
     * @param value
     *            value
     */
    public void sendKeysWithOutClear(final WebElement element, final String value) {

        try {
            scrollTo(element);
            getHighlightElementYellowColour(element);
            element.sendKeys(value);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);

        }
    }

    /**
     * enter value to given element.
     * 
     * @param element
     *            element
     * @param keys
     *            keys
     */
    public void sendKeys(final WebElement element, final Keys keys) {

        try {

            scrollTo(element);
            // clear(element);
            element.sendKeys(keys);

        } catch (NoSuchElementException nsee) {

            LOGGER.warn(MessageFormat.format(FAILED_TO_ENTER_VALUE_TO_GIVEN_ELEMENT_MESSAGE, element), nsee);

        }

    }

    /**
     * 
     * @param element
     *            element
     * @return text as string from given element otherwise null if no text found;
     */
    public String getText(final WebElement element) {

        try {
            scrollTo(element);
            getHighlightElementYellowColour(element);
            return element.getText().trim();
        } catch (NoSuchElementException nsee) {

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());

        }
        return null;
    }

    /**
     * Switch to given frame number.
     * 
     * @param frameNo
     *            frameNo
     * @throws InterruptedException
     *             InterruptedException
     */
    public void swithToFrame(final int frameNo) throws InterruptedException {

        utilities.timeInterval(Utilities.TIME_INTERVAL_FOR_THREE_SECONDS);

        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .frame(frameNo);

    }

    /**
     * enter given url.
     * 
     * @param url
     *            url
     */
    public void enterUrl(final String url) {

        WebDriverFactory.getWebDriver()
                        .get(url);

    }

    /**
     * refresh current page.
     */
    public void refreshPage() {
        WebDriverFactory.getWebDriver()
                        .navigate()
                        .refresh();

    }

    /**
     * check deleted item is displayed on UI or not.
     * 
     * @param elementID
     *            ID
     * 
     * @return true if list size match zero false otherwise
     */
    public Boolean isDisplayedAfterDelete(final String elementID) {

        List<WebElement> deletedItems = WebDriverFactory.getWebDriver()
                                                        .findElements(By.id(elementID));

        boolean isDisplayed = false;

        if (deletedItems.size() == 0) {
            isDisplayed = true;
        } else {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    /**
     * check given element is displayed on UI when user enter with read only right.
     * 
     * @param elementID
     *            elementID
     * @return true if given element is not displayed return false otherwise
     */
    public boolean isDisplayedInReadOnlyAccess(final String elementID) {
        List<WebElement> element = WebDriverFactory.getWebDriver()
                                                   .findElements(By.id(elementID));

        boolean isDisplayed = false;

        if (element.size() == 0) {
            isDisplayed = true;
        } else {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    /**
     * check cancelled item is displayed on UI or not.
     * 
     * @param elementID
     *            ID
     * 
     * @return true if list size match zero false otherwise
     */
    public Boolean isDisplayedAfterSelectingCancel(final String elementID) {

        return isDisplayedAfterDelete(elementID);
    }

    /**
     * check closed item is displayed on UI or not.
     * 
     * @param elementID
     *            ID
     * 
     * @return true if list size match zero false otherwise
     */
    public Boolean isDisplayedAfterSelectingClose(final String elementID) {

        return isDisplayedAfterDelete(elementID);
    }

    /**
     * check if given file download at given path.
     * 
     * @param downloadPath
     *            path to check download file for
     * 
     * @param fileName
     *            file name to check for
     * @return true if given file found at given path
     */
    public boolean isFileDownloaded(final String downloadPath, final String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName()
                              .equals(fileName)) {
                flag = true;
            }
        }
        return flag;

    }

    /**
     * verify is given page displayed.
     * 
     * @param pageNumber
     *            page number
     * @return true if given page displayed or false otherwise
     */
    public boolean isRightPageDisplayed(final String pageNumber) {
        boolean rightPage = false;
        if (isDisplayed(WebDriverFactory.getWebDriver()
                                        .findElement(By.xpath(".//li[@class='pagination-page ng-scope active']//a[normalize-space(text())='"
                                                + pageNumber + "']")))) {
            rightPage = true;
        } else {
            rightPage = false;
        }
        return rightPage;
    }

    /**
     * check is any manual uploaded entry displayed on dash board.
     * 
     * @return true if entry displayed false otherwise
     */
    public Boolean isAnyEntryDisplayedOnTable() {
        utilities.timeInterval(1);

        boolean entry = false;
        if (isDisplayed(WebDriverFactory.getWebDriver()
                                        .findElement(By.xpath(".//table/tbody/tr[1]")))) {
            entry = true;
        } else {
            entry = false;
        }
        return entry;
    }

    /**
     * Check if dates are sorted in order or not.
     * 
     * @param order
     *            order to check
     * @throws ParseException
     *             ParseException
     * 
     * @return true if date is sorted in given order or false otherwise.
     * @throws ParseException
     *             ParseException
     */
    public boolean isDateSortedInOrder(final String order) throws ParseException {

        List<WebElement> totalDatesElements = WebDriverFactory.getWebDriver()
                                                              .findElements(By.xpath(".//tbody[1]//td[5]"));
        List<String> dates = new ArrayList<>();

        for (int i = 1; i <= totalDatesElements.size(); i++) {
            dates.add(WebDriverFactory.getWebDriver()
                                      .findElement(By.xpath(".//tbody[1]/tr[ " + i + " ]//td[5]"))
                                      .getText());

        }

        List<Date> dateList = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (String s : dates) {

            Date date = formatter.parse(s);

            dateList.add(date);

        }

        Collections.sort(dateList);
        if (order.equalsIgnoreCase("decending")) {
            Collections.reverse(dateList);
        }

        List<String> dateString = new ArrayList<>();
        for (Date s : dateList) {

            dateString.add(formatter.format(s));

        }

        return dates.equals(dateString);

    }

    /**
     * Check if given element is clickble or not.
     * 
     * @param element
     *            element to check
     * @return true if element is clickble false otherwise.
     */
    public boolean isClickable(final WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), Utilities.TIME_INTERVAL_FOR_FIVE_SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * check how many number of records displayed on page.
     * 
     * @return number of records display on page.
     */
    public int numberOfRecordsDisplayOnPage() {

        List<WebElement> flag = WebDriverFactory.getWebDriver()
                                                .findElements(By.xpath(".//tbody[1]//tr"));

        return flag.size();

    }

    /**
     * check given element is displayed on form or not while editing page.
     * 
     * @param elementID
     *            ID
     * 
     * @return true if list size match zero false otherwise
     */
    public Boolean isDisplayedWhileEditingForm(final String elementID) {

        return isDisplayedAfterDelete(elementID);
    }

    /**
     * enter given value to alert pop up.
     * 
     * @param value
     *            value to enter in alert pop up.
     */
    public void sendValueToAleartWindow(final String value) {

        getAlertPopUp().sendKeys(value);
        getAlertPopUp().accept();
    }

    /**
     * check given xpath is displayed on UI or not.
     * 
     * @param elementXPATH
     *            elementXPATH
     * 
     * @return false if list size match zero true otherwise
     */

    public boolean isGivenXpathDisplayedOnScreen(final String elementXPATH) {

        return WebDriverFactory.getWebDriver()
                               .findElements(By.xpath(elementXPATH))
                               .size() != 0;
    }

    /**
     * check given ID is displayed on UI or not.
     * 
     * @param elementID
     *            elementID
     * 
     * @return false if list size match zero true otherwise
     */

    public boolean isGivenIDDisplayedOnScreen(final String elementID) {
        return WebDriverFactory.getWebDriver()
                               .findElements(By.id(elementID))
                               .size() != 0;

    }

    /**
     * Change to tab as per given number.
     * 
     * @param number
     *            number
     */
    public void switchBitweenTab(int number) {
        ArrayList<String> tabs2 = new ArrayList<String>(WebDriverFactory.getWebDriver()
                                                                        .getWindowHandles());
        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .window(tabs2.get(number));

    }

    /**
     * Enter user name and password for US url authentication.
     */
    public void enterUserNameAndPasswordForUSAuthorisation() {
        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .alert()
                        .sendKeys(AutomationConstant.US_AUTHORISATION_USER_NAME + Keys.TAB + AutomationConstant.US_AUTHORISATION_PASSWORD);

    }

    /**
     * Accept alert.
     */
    public void alertAccept() {
        WebDriverFactory.getWebDriver()
                        .switchTo()
                        .alert()
                        .accept();

    }
}
