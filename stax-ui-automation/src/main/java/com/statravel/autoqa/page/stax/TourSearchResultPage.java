package com.statravel.autoqa.page.stax;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.AutomationConstant;
import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class TourSearchResultPage extends Page<TourSearchResultPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private TourSearchResultPageElements tourSearchResultPageElements;

    /**
     * 
     */
    @Override
    public boolean isPageLoaded() {
        return webDriverCommons.isDisplayed(tourSearchResultPageElements.firstTourSelect);

    }

    /**
     * 
     */
    @Override
    public void init() {
        tourSearchResultPageElements = new TourSearchResultPageElements();
        super.initialiseElements(tourSearchResultPageElements);

    }

    /**
     * 
     */
    @Override
    public TourSearchResultPageElements getPageElements() {
        return tourSearchResultPageElements;
    }

    /**
     * Enter given value into search box.
     * 
     * @param value
     *            value to enter in search box
     */
    public void enterValueInSearchBoxInput(String value) {
        webDriverCommons.sendKeys(tourSearchResultPageElements.txtSearchInput, value);
    }

    /**
     * Verify search results contains given value or not.
     * 
     * @param value
     *            value to verify
     * @return true if search results contains given value, false otherwise
     */
    public boolean isSearchResultContainGivenValue(String value) {
        boolean flag = true;

        List<WebElement> deletedItems = tourSearchResultPageElements.searchResults;

        if (deletedItems.size() == 0) {
            flag = false;
        }

        for (WebElement element : deletedItems) {

            String text = element.getText();

            if (!text.toLowerCase()
                     .contains(value)) {

                flag = false;
                break;
            }
        }

        return flag;
    }

    /**
     * Get current value from sort by drop down.
     * 
     * @return current value text from sort by drop down
     * 
     */
    public String getTextFromSortByDropdown() {

        Select selectedValue = new Select(tourSearchResultPageElements.sortByDropdown);

        WebElement selectedText = selectedValue.getFirstSelectedOption();

        return selectedText.getText();
    }

    /**
     * Verify minimum six tours are loaded or not.
     * 
     * @return true if minimum six tours are loaded, false otherwise
     */
    public boolean isToursLoaded() {

        return tourSearchResultPageElements.loadedTourBoxs.size() >= AutomationConstant.MINIMUN_TOURS_NEED_TO_LOAD;
    }

    /**
     * 
     */
    public String getPriceForFirstTour() {
        return webDriverCommons.getText(tourSearchResultPageElements.firstTourPrice)
                               .replace(",", "");

    }
}
