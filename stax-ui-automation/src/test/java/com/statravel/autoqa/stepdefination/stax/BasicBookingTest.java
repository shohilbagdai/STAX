package com.statravel.autoqa.stepdefination.stax;

import java.text.MessageFormat;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.StaxAsseartionMessages;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.config.ApplicationProperties;
import com.statravel.autoqa.domain.enumeration.POS;
import com.statravel.autoqa.page.stax.BookingOnePage;
import com.statravel.autoqa.page.stax.BookingTwoPage;
import com.statravel.autoqa.page.stax.ConfirmationPage;
import com.statravel.autoqa.page.stax.SelectedTourPage;
import com.statravel.autoqa.page.stax.TourSearchResultPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class BasicBookingTest {

    public static final String SELECTED_TOUR_PAGE = "Selected Tour Page";
    public static final String BOOKING_ONE_PAGE = "Booking One Page";
    public static final String BOOKING_TWO_PAGE = "Booking Two Page";
    public static final String CONFIRMATION_PAGE = "Confirmation Page";
    public static final String TOUR_SEARCH_RESULT_PAGE = "Tour Search Result Page";

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private SelectedTourPage selectedTourPage;

    @Autowired
    private BookingOnePage bookingOnePage;

    @Autowired
    private BookingTwoPage bookingTwoPage;

    @Autowired
    private ConfirmationPage confirmationPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    public String tourPriceFromTourSearchPage;

    @Before
    public void init() {
        tourSearchResultPage.init();
        selectedTourPage.init();
        bookingOnePage.init();
        bookingTwoPage.init();
        confirmationPage.init();
    }

    @Given("^I am on \"([^\"]*)\" tours page$")
    public void iAmOnGivenToursage(final String pos) {

        if (pos.equalsIgnoreCase(POS.UK.toString())) {
            webDriverCommons.enterUrl(ApplicationProperties.getUkBaseURL());
        } else if (pos.equalsIgnoreCase(POS.NZ.toString())) {
            webDriverCommons.enterUrl(ApplicationProperties.getNzBaseURL());
        } else if (pos.equalsIgnoreCase(POS.AU.toString())) {
            webDriverCommons.enterUrl(ApplicationProperties.getAuBaseURL());
        } else if (pos.equalsIgnoreCase(POS.USA.toString())) {
            webDriverCommons.enterUrl(ApplicationProperties.getUsBaseURL());

            webDriverCommons.enterUserNameAndPasswordForUSAuthorisation();

            webDriverCommons.alertAccept();
        }

        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.PAGE_NOT_LOADED, TOUR_SEARCH_RESULT_PAGE + " for " + pos),
                tourSearchResultPage.isPageLoaded());
    }

    @When("^I select a tour$")
    public void iSelectATour() {
        webDriverCommons.click(tourSearchResultPage.getPageElements().firstTourSelect);
    }

    @Then("^I should be on tour details page$")
    public void iShouldBeOnTourDetailsPage() {
        webDriverCommons.switchBitweenTab(StaxAsseartionMessages.SWITCH_TO_FIRST_TAB);

        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.PAGE_NOT_LOADED, SELECTED_TOUR_PAGE), selectedTourPage.isPageLoaded());
    }

    @When("^I select BOOK NOW button$")
    public void iSelectBOOKNOWButton() {
        selectedTourPage.selectBookNowButton();
    }

    @Then("^I should be on booking one page$")
    public void iShouldBeOnBookingOnePage() {
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.PAGE_NOT_LOADED, BOOKING_ONE_PAGE), bookingOnePage.isPageLoaded());

    }

    @When("^I select continue button on booking one page$")
    public void iSelectCountinueOnBookingOnePage() {
        bookingOnePage.clickOnContinueButton();
    }

    @Then("^I should be on booking two page$")
    public void iShouldBeOnBookingTwoPage() {
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.PAGE_NOT_LOADED, BOOKING_TWO_PAGE), bookingTwoPage.isPageLoaded());
    }

    @When("^I fill all traveller details for \"([^\"]*)\"$")
    public void iFillAllTravellerDetails(String pos) {
        bookingTwoPage.fillAllBookingDetails(pos);
    }

    @When("^select book now$")
    public void selectBookNow() {
        bookingTwoPage.selectBookNowButton();
    }

    @Then("^I should be on confirmation page$")
    public void iShouldBeOnConfirmationPage() {
        Assert.assertTrue(MessageFormat.format(StaxAsseartionMessages.PAGE_NOT_LOADED, CONFIRMATION_PAGE), confirmationPage.isPageLoaded());
    }

    @When("^I get the price for first tour$")
    public void iGetThePriceForFirstTour() {
        tourPriceFromTourSearchPage = tourSearchResultPage.getPriceForFirstTour();
    }

    @Then("^I should see price of the tour on \"([^\"]*)\" is same as tour page$")
    public void iShouldSeePriceOfTheTourOnGivenPageIsSameAsTourPage(String page) {

        if (page.equalsIgnoreCase("tour details page")) {
            String tourPriceOnTourInfoPage;
            tourPriceOnTourInfoPage = selectedTourPage.getTourPrice();
            Assert.assertEquals("", tourPriceFromTourSearchPage, tourPriceOnTourInfoPage);
        } else if (page.equalsIgnoreCase("booking one page")) {
            String tourPriceOnBookingOnePage;
            tourPriceOnBookingOnePage = bookingOnePage.getTourPrice();
            Assert.assertEquals("", tourPriceFromTourSearchPage, tourPriceOnBookingOnePage);
        } else if (page.equalsIgnoreCase("booking two page")) {
            String tourPriceOnBookingTwoPage;
            tourPriceOnBookingTwoPage = bookingTwoPage.getTourPrice();
            Assert.assertEquals("", tourPriceFromTourSearchPage, tourPriceOnBookingTwoPage);
        }
    }
}
