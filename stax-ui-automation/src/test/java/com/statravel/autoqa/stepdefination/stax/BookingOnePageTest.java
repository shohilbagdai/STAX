package com.statravel.autoqa.stepdefination.stax;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.StaxAsseartionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.stax.BookingOnePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class BookingOnePageTest {

    public static final String BOOKING_ONE_PAGE = "Booking One Page";
    public static final String SELECT_NUMBER_OF_PASSENGER_DROPDOWN = "Select number of passenger";
    public static final String TRAVELLERS_DROPDOWN = "Travellers Dropdown";
    public static final String PROMO_CODE_INPUT = "Promo Code Input";
    public static final String PROMO_CODE_APPLY_BUTTON = "Promo Code Apply Button";
    public static final String SPECIAL_REQUEST_INPUT = "Special Request Input";
    public static final String PAY_BUTTON = "Pay Button";
    public static final String HOLD_TOUR_CHECK_BOX = "Hold Tour Check Box";
    public static final String PAY_DEPOSIT_BOOKING_OPTION = "Pay Deposit Booking Option";
    public static final String PAY_FULL_AMOUNT_BOOKING_OPTION = "Pay Full Amount Booking Option";
    public static final String TRIP_TITLE = "Trip title";
    public static final String SELECT_TOUR_YEAR_DROPDOWN = "Select tour year dropdown";
    public static final String SELECT_PREVIOUS_MONTH_BUTTON_AT_BUTTOM = "Select previous month button at bottom";
    public static final String SELECT_NEXT_MONTH_BUTTON_AT_BUTTOM = "Select next month button at bottom";
    public static final String TOUR_PRICE_FOR_SIDE_BAR = "Tour price at side bar";
    public static final String CONTINUE_BUTTON = "Continue button";
    public static final String PAYABLE_TODAY_TOTAL_PRICE = "Payable today total price";
    public static final String TOTAL_PRICE_FOR_BOOKING_ON_BOTTOM = "";
    public static final String WHY_BOOK_WITH_US_FIELD = "Why book with us field";

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private BookingOnePage bookingOnePage;

    @Before
    public void init() {
        bookingOnePage.init();
    }

    @Then("^I should see all fields on Booking one page as expected$")
    public void iShouldSeeAllFieldsOnBookingOnePageAsExpected() {
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, TRIP_TITLE, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePage.getPageElements().tripTitle));
        Assert.assertTrue(
                MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, SELECT_NUMBER_OF_PASSENGER_DROPDOWN, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePage.getPageElements().selectNumberOfPassengerDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, SELECT_TOUR_YEAR_DROPDOWN, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePage.getPageElements().selectTourYearDropdown));
        Assert.assertTrue(
                MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, SELECT_PREVIOUS_MONTH_BUTTON_AT_BUTTOM, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePage.getPageElements().previousMonthButtonOnBottom));
        Assert.assertTrue(
                MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, SELECT_NEXT_MONTH_BUTTON_AT_BUTTOM, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayedWithTwoSecondsWait(bookingOnePage.getPageElements().nextMonthButtonOnBottom));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PROMO_CODE_INPUT, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().couponCodeInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PROMO_CODE_APPLY_BUTTON, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().couponCodeApplyButton));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, TOUR_PRICE_FOR_SIDE_BAR, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().tourPriceOnSideBar));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PAYABLE_TODAY_TOTAL_PRICE, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().payableTodayTotalPrice));
        Assert.assertTrue(
                MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, TOTAL_PRICE_FOR_BOOKING_ON_BOTTOM, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().tourPriceOfBookingOnBottom));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, WHY_BOOK_WITH_US_FIELD, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().whyBookWithUsField));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CONTINUE_BUTTON, BOOKING_ONE_PAGE),
                webDriverCommons.isDisplayed(bookingOnePage.getPageElements().continueButton));

    }

    @When("^I select tour date after seventy days from dropdown$")
    public void iSelectTourDateAfterSeventyDaysFromDropdown() {
        bookingOnePage.getAvailableDateAfterThreeMonts();
    }

    @Then("^I should see HOLD TOUR check box available on page$")
    public void iShouldSeeHoldTourCheckBoxAvailableOnPage() {
        Assert.assertTrue("", webDriverCommons.isDisplayed(bookingOnePage.getPageElements().holdTourCheckBox));
    }

    @Then("^I should see \"([^\"]*)\" option in Booking option field$")
    public void iShouldSeeGivenOptionInBookingOptionField(String bookingOption) {
        if (bookingOption.equalsIgnoreCase("pay deposit")) {
            Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PAY_DEPOSIT_BOOKING_OPTION),
                    webDriverCommons.isDisplayed(bookingOnePage.getPageElements().payDepositBookingOption));
        } else if (bookingOption.equalsIgnoreCase("pay full amount")) {
            Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PAY_FULL_AMOUNT_BOOKING_OPTION),
                    webDriverCommons.isDisplayed(bookingOnePage.getPageElements().payFullAmountBookingOption));
        }
    }

    @Then("^I should see cheapest price selected in calender from all available price$")
    public void iShouldSeeCheapestPriceSelectedInCalenderFromAllAvailablePrice() {
        Assert.assertTrue("Cheapest price is not selected by default", bookingOnePage.isCheapestPriceSelectedByDefault());
    }
}
