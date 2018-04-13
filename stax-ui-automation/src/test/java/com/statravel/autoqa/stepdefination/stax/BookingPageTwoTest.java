package com.statravel.autoqa.stepdefination.stax;

import java.text.MessageFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.StaxAsseartionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.stax.BookingOnePage;
import com.statravel.autoqa.page.stax.BookingTwoPage;
import com.statravel.autoqa.page.stax.SelectedTourPage;
import com.statravel.autoqa.page.stax.TourSearchResultPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class BookingPageTwoTest {

    public static final String FIRST_NAME_INPUT = "First Name input";
    public static final String LAST_NAME_INPUT = "Last Name input";
    public static final String DOB_DATE_DROPDOWN = "DOB Date dropdown";
    public static final String DOB_MONTH_DROPDOWN = "DOB Month dropdown";
    public static final String DOB_YEAR_DROPDOWN = "DOB Year dropdown";
    public static final String GENDER_DROPDOWN = "Gender dropdown";
    public static final String NATIONALITY_DROPDOWN = "Nationality dropdown";
    public static final String PHONE_NUMBER_INPUT = "Phone Number input";
    public static final String EMAIL_ADDRESS_INPUT = "Email Address input";
    public static final String CARD_NAME_INPUT = "Card Name input";
    public static final String CARD_NUMBER_INPUT = "Card Number Input";
    public static final String CARD_EXPIRY_MONTH_DROPDOWN = "Card Expiry Month dropdown";
    public static final String CARD_EXPIRY_YEAR_DROPDOWN = "Card Expiry Year dropdown";
    public static final String CARD_SECURITY_CODE_INPUT = "Card Security Code input";
    public static final String COUNTRY_DROPDOWN = "Country dropdown";
    public static final String STREET_INPUT = "Street input";
    public static final String CITY_INPUT = "City input";
    public static final String STATE_DROPDOWN_FOR_USA = "State dropdown";
    public static final String COUNTY_DROPDOWN = "County Dropdown For US";
    public static final String ZIP_CODE_INPUT = "ZIP Code input";
    public static final String SUPPLIER_BOOKING_T_AND_C_CHECK_BOX = "Supplier booking T And C check box";
    public static final String STA_TRAVEL_T_AND_C_CHECK_BOX = "STA Travel T And C check box";
    public static final String BOOK_NOW_BUTTON = "Book Now button";
    public static final String BOOKINB_TWO_PAGE = "Booking Two page";

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private SelectedTourPage selectedTourPage;

    @Autowired
    private BookingOnePage bookingOnePage;

    @Autowired
    private BookingTwoPage bookingTwoPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Before
    public void init() {
        tourSearchResultPage.init();
        selectedTourPage.init();
        bookingOnePage.init();
        bookingTwoPage.init();
    }

    @Then("^I should see all fields on Booking Two page as expected for \"([^\"]*)\"$")
    public void iShouldSeeAllFieldsOnBookingTwoPageAsExpectedForGivenPOS(String pos) {
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, FIRST_NAME_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().firstNameInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, LAST_NAME_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().lastNameInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, DOB_DATE_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().dOBDateDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, DOB_MONTH_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().dOBMonthDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, DOB_YEAR_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().dOBYearDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, GENDER_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().genderDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, NATIONALITY_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().nationalityDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, PHONE_NUMBER_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().phoneNumberInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, EMAIL_ADDRESS_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().emailInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CARD_NAME_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().nameOnCardInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CARD_NUMBER_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().cardNumberInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CARD_EXPIRY_MONTH_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().cardExpiryMonthDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CARD_EXPIRY_YEAR_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().cardExpiryYearDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CARD_SECURITY_CODE_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().cardSecurityCodeInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, COUNTRY_DROPDOWN, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().countryDropdown));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, STREET_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().streetInput));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, CITY_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().cityInput));

        if (pos.equalsIgnoreCase(POS.USA.toString())) {
            Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, STATE_DROPDOWN_FOR_USA, BOOKINB_TWO_PAGE),
                    webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().stateDropdown));
        }

        if (!pos.equalsIgnoreCase(POS.USA.toString())) {
            Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, COUNTY_DROPDOWN, BOOKINB_TWO_PAGE),
                    webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().countryInput));
        }
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, ZIP_CODE_INPUT, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().postCodeInput));
        Assert.assertTrue(
                MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, SUPPLIER_BOOKING_T_AND_C_CHECK_BOX, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().tourSupplierTAndCCheckBox));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, STA_TRAVEL_T_AND_C_CHECK_BOX, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().staTAndCCheckBox));
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.FIELD_IS_NOT_DISPLAYED_ON_PAGE, BOOK_NOW_BUTTON, BOOKINB_TWO_PAGE),
                webDriverCommons.isDisplayed(bookingTwoPage.getPageElements().bookNowButon));

    }

}
