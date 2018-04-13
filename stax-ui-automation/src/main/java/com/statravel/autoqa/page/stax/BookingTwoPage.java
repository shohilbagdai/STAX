package com.statravel.autoqa.page.stax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class BookingTwoPage extends Page<BookingTwoPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private BookingTwoPageElements bookingTwoPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(bookingTwoPageElements.firstNameInput);
    }

    /**
     * 
     */
    @Override
    public void init() {
        bookingTwoPageElements = new BookingTwoPageElements();
        super.initialiseElements(bookingTwoPageElements);

    }

    /**
     * 
     */
    @Override
    public BookingTwoPageElements getPageElements() {
        return bookingTwoPageElements;
    }

    /**
     * Enter all tour and passenger details as per given POS.
     * 
     * @param pos
     *            POS
     */
    public void fillAllBookingDetails(String pos) {
        webDriverCommons.sendKeys(bookingTwoPageElements.firstNameInput, "Auto");

        webDriverCommons.sendKeys(bookingTwoPageElements.lastNameInput, "Test");

        webDriverCommons.selectFromDropdown(bookingTwoPageElements.dOBDateDropdown, "1");

        webDriverCommons.selectFromDropdown(bookingTwoPageElements.dOBMonthDropdown, "1");

        webDriverCommons.selectFromDropdown(bookingTwoPageElements.dOBYearDropdown, "1983");

        webDriverCommons.sendKeys(bookingTwoPageElements.phoneNumberInput, "123456789");

        webDriverCommons.sendKeys(bookingTwoPageElements.emailInput, "s@gmail.com");

        webDriverCommons.sendKeys(bookingTwoPageElements.nameOnCardInput, "AUTHORISED");

        webDriverCommons.sendKeys(bookingTwoPageElements.cardNumberInput, "4444333322221111");

        webDriverCommons.selectFromDropdown(bookingTwoPageElements.cardExpiryMonthDropdown, "1");

        webDriverCommons.selectFromDropdown(bookingTwoPageElements.cardExpiryYearDropdown, "2025");

        webDriverCommons.sendKeys(bookingTwoPageElements.cardSecurityCodeInput, "123");

        webDriverCommons.sendKeys(bookingTwoPageElements.streetInput, "Test street");

        webDriverCommons.sendKeys(bookingTwoPageElements.cityInput, "Test city");

        if (!pos.equalsIgnoreCase(POS.USA.toString())) {
            webDriverCommons.sendKeys(bookingTwoPageElements.countryInput, "Test Country");
        }

        webDriverCommons.sendKeys(bookingTwoPageElements.postCodeInput, "Test post code");

        webDriverCommons.click(bookingTwoPageElements.tourSupplierTAndCCheckBox);

        webDriverCommons.click(bookingTwoPageElements.staTAndCCheckBox);

    }

    /**
     * Select book now button.
     */
    public void selectBookNowButton() {
        webDriverCommons.click(bookingTwoPageElements.bookNowButon);

    }

    /**
     * Get tour price from page.
     * @return tour price from Booking two page as string without (,).
     */
    public String getTourPrice() {

        return webDriverCommons.getText(bookingTwoPageElements.amountDueSideBar)
                               .replace(",", "");
    }
}
