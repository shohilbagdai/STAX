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
public class ConfirmationPage extends Page<ConfirmationPageElement> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private ConfirmationPageElement confirmationPageElement;

    @Override
    public boolean isPageLoaded() {
        return webDriverCommons.isDisplayed(confirmationPageElement.confirmTagSelected);
    }

    @Override
    public void init() {
        confirmationPageElement = new ConfirmationPageElement();
        super.initialiseElements(confirmationPageElement);
    }

    @Override
    public ConfirmationPageElement getPageElements() {
        return confirmationPageElement;
    }

}
