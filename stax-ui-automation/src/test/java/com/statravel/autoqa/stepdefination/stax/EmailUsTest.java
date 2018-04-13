package com.statravel.autoqa.stepdefination.stax;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.stax.EmailUsPopUpPage;
import com.statravel.autoqa.page.stax.SelectedTourPage;
import com.statravel.autoqa.page.stax.TourSearchResultPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class EmailUsTest {

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private SelectedTourPage selectedTourPage;

    @Autowired
    private EmailUsPopUpPage emailUsPopUpPage;

    @Before
    public void init() {
        tourSearchResultPage.init();
        selectedTourPage.init();
        emailUsPopUpPage.init();
    }

    @When("^I select Email us on tours details page$")
    public void iSelectEmailUsOnToursDetailsPage() {
        selectedTourPage.selectEmailUsButton();
    }

    @Then("^I should see Email us pop up windown$")
    public void iShouldSeeEmailUsPopUpWindown() {

        Assert.assertTrue("Email us page is not loaded", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().firstNameInput));

    }

    @Then("^I should see all required inputs in Email us pop up window$")
    public void iShouldSeeAllRequiredInputsInEmailUsPopUpWindow() {
        Assert.assertTrue("First name input", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().firstNameInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().lastNameInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().emailInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().phoneNumberInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().dobDropdown));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().dobMonthDropdown));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().dobYearDropdown));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().departureMonthInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().howCanWeHelpDropdown));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().howCanWeHelpInput));
        Assert.assertTrue("", webDriverCommons.isDisplayed(emailUsPopUpPage.getPageElements().submitEmailButtton));
    }

}
