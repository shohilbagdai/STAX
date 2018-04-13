package com.statravel.autoqa.page.stax;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class EmailUsPopUpPageElements extends PageElements {

    @FindBy(id = "txteffirstname")
    public WebElement firstNameInput;

    @FindBy(id = "txteflastname")
    public WebElement lastNameInput;

    @FindBy(id = "txtefemail")
    public WebElement emailInput;

    @FindBy(id = "txtefphone")
    public WebElement phoneNumberInput;

    @FindBy(id = "dobefDate")
    public WebElement dobDropdown;

    @FindBy(id = "dobefMonth")
    public WebElement dobMonthDropdown;

    @FindBy(id = "dobefYear")
    public WebElement dobYearDropdown;

    @FindBy(id = "ddlefdepartureMonth")
    public WebElement departureMonthInput;

    @FindBy(id = "ddlefHelp")
    public WebElement howCanWeHelpDropdown;

    @FindBy(id = "txtefinfo")
    public WebElement howCanWeHelpInput;

    @FindBy(id = "btnSubmit")
    public WebElement submitEmailButtton;
}
