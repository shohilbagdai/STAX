package com.statravel.autoqa.stepdefination.stax;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.statravel.autoqa.CucumberStepsDefinition;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.stax.TourSearchResultPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

/**
 * 
 * @author STA Development Team
 *
 */
@CucumberStepsDefinition
public class TourLoadFunctanilityTest {

    @Autowired
    private TourSearchResultPage tourSearchResultPage;

    @Autowired
    private WebDriverCommons webDriverCommons;

    @Before
    public void init() {
        tourSearchResultPage.init();
    }
    
    @Then("^I should see tours are loaded on the page$")
    public void iShouldSeeToursAreLoadedOnThePage() {
        Assert.assertTrue("", tourSearchResultPage.isToursLoaded());
    }

}
