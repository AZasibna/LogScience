package com.cs.automationframework.pageobjects;

import com.cs.automationframework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomMetadataType {
    public CustomMetadataType(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//iframe[contains(@name,'vfFrameId_')]")
    public WebElement iframe;
    @FindBy (xpath = "//h2[@class='pageDescription']")
    public WebElement logScienceLable;
}
