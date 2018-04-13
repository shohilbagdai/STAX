package com.statravel.autoqa.page.stax;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.statravel.autoqa.page.PageElements;

public class ConfirmationPageElement extends PageElements {

    @FindBy(xpath = ".//span[@class='selected' and normalize-space(text())='Confirm']")
    public WebElement confirmTagSelected;

}
