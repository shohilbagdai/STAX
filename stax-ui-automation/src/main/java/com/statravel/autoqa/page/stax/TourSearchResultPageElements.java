package com.statravel.autoqa.page.stax;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

public class TourSearchResultPageElements extends PageElements {

    @FindBy(xpath = ".//div[@id='products']/div[1]//div[@class='day-price']//a")
    public WebElement firstTourSelect;

    @FindBy(id = "txtSearch")
    public WebElement txtSearchInput;

    @FindBy(id = "ui-id-1")
    public WebElement searchResultPopUp;

    @FindBy(xpath = "//ul[@id='ui-id-1']//li[@class='ui-menu-item']")
    public List<WebElement> searchResults;

    @FindBy(id = "sortSelect")
    public WebElement sortByDropdown;

    @FindBy(xpath = ".//*[@id='products']//div[@class='caption']")
    public List<WebElement> loadedTourBoxs;

    @FindBy(xpath = "//span[@class='trip-price-inner'][1]")
    public WebElement firstTourPrice;

}
