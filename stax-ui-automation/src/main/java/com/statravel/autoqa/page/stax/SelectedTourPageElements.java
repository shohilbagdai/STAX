package com.statravel.autoqa.page.stax;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.statravel.autoqa.page.PageElements;

/**
 * 
 * @author STA Development Team
 *
 */
public class SelectedTourPageElements extends PageElements {

    @FindBy(css = ".btn-sta.btn-primary.btn-book")
    public WebElement bookNowButton;

    @FindBy(xpath = "//li[@class='misc-col5']//a[1]")
    public WebElement emailUsButton;
    
    @FindBy(css = ".b-price")
    public WebElement tourPrice;
}
