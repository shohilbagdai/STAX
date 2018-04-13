package com.statravel.autoqa.stepdefination.stax;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.WebDriverCommons;
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
public class TourSearchFunctainalityTest {

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Before
    public void init() {
        tourSearchResultPage.init();

    }

    @When("^I search for \"([^\"]*)\" in search input area$")
    public void iSearchForGivenValueInSearchArea(final String searchValue) {
        tourSearchResultPage.enterValueInSearchBoxInput(searchValue);
    }

    @Then("^I should see search result pop up comes up$")
    public void iShouldSeeSearchResultPopUpComesUp() {
        Assert.assertTrue("", webDriverCommons.isDisplayed(tourSearchResultPage.getPageElements().searchResultPopUp));
    }

    @Then("^I should see returned search result contains \"([^\"]*)\" which I searched for$")
    public void iShouldSeeResultContainGivenSearchValue(final String searchValue) {
        Assert.assertTrue("Search results not contains entered search criateria", tourSearchResultPage.isSearchResultContainGivenValue(searchValue));
    }

}
