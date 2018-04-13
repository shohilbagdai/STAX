package com.statravel.autoqa.page.stax;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class BookingOnePageElements extends PageElements {
    @FindBy(xpath = ".//div[contains(@class,'trip-title')]//h2")
    public WebElement tripTitle;

    @FindBy(css = ".downArrow")
    public WebElement selectTourYearDropdown;

    @FindBy(id = "txtTravellers")
    public WebElement selectNumberOfPassengerDropdown;

    @FindBy(css = ".txt-promo")
    public WebElement couponCodeInput;

    @FindBy(css = ".btn-apply")
    public WebElement couponCodeApplyButton;

    @FindBy(id = "txtComment")
    public WebElement commentInput;

    @FindBy(id = "txtComment")
    public WebElement splRequestsInput;

    @FindBy(css = ".opt-sp-note")
    public WebElement holdTourCheckBox;

    @FindBy(css = ".btn-common")
    public WebElement continueButton;

    // @FindBy(id = "selDates_2")
    // public WebElement selectTourDateDropDown;
    //
    // @FindBy(css = "#tbxMultiDayTripDates")
    // public WebElement selectTourDateCalenderView;

    // @FindBy(xpath = ".//div[@id='divBeforeFinalDueDateB']//input")
    // public WebElement bookButton;
    //
    // @FindBy(xpath = ".//*[@id='divBeforeFinalDueDateB' and @style='']//input")
    // public WebElement payDepositButton;
    //
    // @FindBy(xpath = ".//*[@id='divBeforeFinalDueDateH']//input")
    // public WebElement holdTourButton;
    //
    // @FindBy(xpath = ".//*[@id='divFullPayment']//input")
    // public WebElement bookNowButton;
    //
    @FindBy(xpath = "//span[.='< PREVIOUS MONTH']")
    public WebElement previousMonthButtonOnBottom;

    @FindBy(xpath = ".//span[@class='month-nav bottom-left month-nav-disabled']")
    public WebElement previousMonthDisableButtonOnBottom;

    @FindBy(xpath = ".//span[@class='month-nav bottom-right']")
    public WebElement nextMonthButtonOnBottom;

    @FindBy(xpath = ".//span[@class='month-nav bottom-right month-nav-disabled']")
    public WebElement nextMonthDisableButtonOnBottom;

    @FindBy(css = ".tot-price")
    public WebElement tourPriceOnSideBar;

    @FindBy(css = ".dep-tot .ng-binding")
    public WebElement tourPriceOfBookingOnBottom;

    @FindBy(xpath = ".//span[@class='dep-amt']")
    public WebElement payableTodayTotalPrice;

    @FindBy(xpath = "//div[@class='blue-body gray-box']//p[normalize-space(text())='Pay deposit']")
    public WebElement payDepositBookingOption;

    @FindBy(xpath = "//div[@class='blue-body gray-box']//p[normalize-space(text())='Pay full amount']")
    public WebElement payFullAmountBookingOption;

    @FindBy(css = ".why-book ")
    public WebElement whyBookWithUsField;

    @FindBy(xpath = ".//div[starts-with(@class,'price ng-binding')]")
    public List<WebElement> datesWithPriceAvailabe;

    @FindBy(xpath = ".//div[contains(@class,'selectedDate')]//..//div[contains(@class,'price')]")
    public WebElement selectedPriceOnCalender;

    // .//div[contains(@class,'selectedDate')]

}
