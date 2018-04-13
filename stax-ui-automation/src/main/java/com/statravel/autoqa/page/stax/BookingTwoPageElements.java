package com.statravel.autoqa.page.stax;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

public class BookingTwoPageElements extends PageElements {

    @FindBy(id = "txtAFirstName_0")
    public WebElement firstNameInput;

    @FindBy(id = "txtALastName_0")
    public WebElement lastNameInput;

    @FindBy(id = "ddlDOBADate_0")
    public WebElement dOBDateDropdown;

    @FindBy(id = "ddlDOBAMonth_0")
    public WebElement dOBMonthDropdown;

    @FindBy(id = "ddlDOBAYear_0")
    public WebElement dOBYearDropdown;

    @FindBy(id = "ddlAGender_0")
    public WebElement genderDropdown;

    @FindBy(id = "ddlANationalities_0")
    public WebElement nationalityDropdown;

    @FindBy(id = "txtPhoneNo")
    public WebElement phoneNumberInput;

    @FindBy(id = "txtEmailAddress")
    public WebElement emailInput;

    @FindBy(id = "txtCardName")
    public WebElement nameOnCardInput;

    @FindBy(id = "txtCardNumber")
    public WebElement cardNumberInput;

    @FindBy(id = "ddlExpirationMonth")
    public WebElement cardExpiryMonthDropdown;

    @FindBy(id = "ddlExpirationYear")
    public WebElement cardExpiryYearDropdown;

    @FindBy(id = "txtSecurityCode")
    public WebElement cardSecurityCodeInput;

    @FindBy(id = "ddlCountry")
    public WebElement countryDropdown;

    @FindBy(id = "ddlState")
    public WebElement stateDropdown;

    @FindBy(id = "txtBillingStreet")
    public WebElement streetInput;

    @FindBy(id = "txtBillingCity")
    public WebElement cityInput;

    @FindBy(id = "txtState")
    public WebElement countryInput;

    @FindBy(id = "txtZipCode")
    public WebElement postCodeInput;

    @FindBy(id = "chkCancellationPolicy")
    public WebElement tourSupplierTAndCCheckBox;

    @FindBy(id = "chkTermsofService")
    public WebElement staTAndCCheckBox;

    @FindBy(css = ".btn-green")
    public WebElement bookNowButon;

    @FindBy(xpath = "//div[@id='sticker']//strong")
    public WebElement amountDueSideBar;

}
