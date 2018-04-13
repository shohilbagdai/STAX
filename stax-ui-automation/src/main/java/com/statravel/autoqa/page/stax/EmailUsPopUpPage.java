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
public class EmailUsPopUpPage extends Page<EmailUsPopUpPageElements> {

    @Autowired
    private WebDriverCommons webDriverCommons;

    private EmailUsPopUpPageElements emailUsPopUpPageElements;

    @Override
    public boolean isPageLoaded() {

        return webDriverCommons.isDisplayed(emailUsPopUpPageElements.submitEmailButtton);
    }

    @Override
    public void init() {
        emailUsPopUpPageElements = new EmailUsPopUpPageElements();
        super.initialiseElements(emailUsPopUpPageElements);

    }

    @Override
    public EmailUsPopUpPageElements getPageElements() {

        return emailUsPopUpPageElements;
    }

}
