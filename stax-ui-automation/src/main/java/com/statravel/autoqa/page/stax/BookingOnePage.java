package com.statravel.autoqa.page.stax;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;
import com.statravel.autoqa.page.Page;

@Service
public class BookingOnePage extends Page<BookingOnePageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private BookingOnePageElements bookingOnePageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {
        return (webDriverCommons.isDisplayed(bookingOnePageElements.selectNumberOfPassengerDropdown));
    }

    /**
     * 
     */
    @Override
    public void init() {
        bookingOnePageElements = new BookingOnePageElements();
        super.initialiseElements(bookingOnePageElements);

    }

    /**
     * 
     */
    @Override
    public BookingOnePageElements getPageElements() {
        return bookingOnePageElements;
    }

    /**
     * Click on continue button.
     */
    public void clickOnContinueButton() {

        webDriverCommons.click(bookingOnePageElements.continueButton);

    }

    /**
     * select available date after three months.
     */
    public void getAvailableDateAfterThreeMonts() {

        for (int i = 1; i < 10; i++) {

            webDriverCommons.click(bookingOnePageElements.nextMonthButtonOnBottom);

            if (i > 3) {
                List<WebElement> selectableDates = WebDriverFactory.getWebDriver()
                                                                   .findElements(By.xpath(
                                                                           ".//div[@class='calendar']//div[starts-with(@class,'price ng-binding ng-scope')]"));
                if (selectableDates.size() >= 1) {
                    selectableDates.get(0)
                                   .click();
                    break;
                }
            }
        }

    }

    /**
     * Get tour price.
     * 
     * @return tour price from Booking one page as string without (,).
     */
    public String getTourPrice() {

        return webDriverCommons.getText(bookingOnePageElements.tourPriceOnSideBar)
                               .replace(",", "");
    }

    /**
     * Verify is cheapest price is selected by default or not.
     * 
     * @return true if cheapest price selected by default false otherwise.
     */
    public boolean isCheapestPriceSelectedByDefault() {

        boolean flag = false;
        String selectedPrice = webDriverCommons.getText(bookingOnePageElements.selectedPriceOnCalender)
                                               .substring(1);
        int selectedPriceInInt = Integer.parseInt(selectedPrice);

        while (!webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePageElements.previousMonthDisableButtonOnBottom)) {
            webDriverCommons.click(bookingOnePageElements.previousMonthButtonOnBottom);
        }
        flag = getMinimumPriceFromMonth() >= selectedPriceInInt;

        while (!webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePageElements.nextMonthDisableButtonOnBottom)) {
            bookingOnePageElements.nextMonthButtonOnBottom.click();
            flag = getMinimumPriceFromMonth() >= selectedPriceInInt;
        }

        return flag;
    }

    /**
     * Get minimum price from selected month.
     * 
     * @return minimum price as int from selected month.
     */
    public int getMinimumPriceFromMonth() {
        List<WebElement> totalDatesWithPrice = bookingOnePageElements.datesWithPriceAvailabe;

        while (totalDatesWithPrice.size() < 1) {
            webDriverCommons.click(bookingOnePageElements.nextMonthButtonOnBottom);
        }
        int minimum = Integer.parseInt(totalDatesWithPrice.get(0)
                                                          .getText()
                                                          .substring(1));

        for (WebElement element : totalDatesWithPrice) {
            int price = Integer.parseInt(element.getText()
                                                .substring(1));
            if (minimum > price) {
                minimum = price;
            }
        }

        return minimum;

    }
}
