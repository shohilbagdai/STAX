package com.statravel.autoqa.stepdefination.stax;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.commons.WebDriverFactory;
import com.statravel.autoqa.page.stax.TourSearchResultPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class SortByFundtionTest {

    public static final String EXPECTED_SORT_BY_FUNCTION = "Recommendation";

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Before
    public void init() {
        tourSearchResultPage.init();

    }

    @Then("^I should see Sort by dropdown on tours page$")
    public void iShouldSeeSortByDropdownOnToursPage() {
        Assert.assertTrue("Sort by dropdown is not displayed on tour result page",
                webDriverCommons.isDisplayed(tourSearchResultPage.getPageElements().sortByDropdown));

    }

    @Then("^RECOMMENDATION should be selected by default$")
    public void recommendationShouldBeSelectedByDefault() {
        String textFromElement = tourSearchResultPage.getTextFromSortByDropdown();

        Assert.assertTrue("Default Sort by function is not as expected", textFromElement.equalsIgnoreCase(EXPECTED_SORT_BY_FUNCTION));
    }

}
