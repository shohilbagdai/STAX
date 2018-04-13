package com.statravel.autoqa.page.stax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statravel.autoqa.commons.WebDriverCommons;
import com.statravel.autoqa.page.Page;

/**
 * 
 * @author STA Development Team
 *
 */
@Service
public class SelectedTourPage extends Page<SelectedTourPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private SelectedTourPageElements selectedTourPageElements;

    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(selectedTourPageElements.bookNowButton);
    }

    @Override
    public void init() {
        selectedTourPageElements = new SelectedTourPageElements();
        super.initialiseElements(selectedTourPageElements);

    }

    @Override
    public SelectedTourPageElements getPageElements() {
        return selectedTourPageElements;
    }

    public void selectBookNowButton() {
        webDriverCommons.click(selectedTourPageElements.bookNowButton);
    }

    /**
     * Select email us button on page.
     */
    public void selectEmailUsButton() {
        webDriverCommons.click(selectedTourPageElements.emailUsButton);
    }

    /**
     * 
     * @return tour price from page.
     */
    public String getTourPrice() {

        return webDriverCommons.getText(selectedTourPageElements.tourPrice).replace(",", "");
    }
}
