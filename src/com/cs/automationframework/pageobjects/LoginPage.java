package com.cs.automationframework.pageobjects;

import com.cs.automationframework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="username")
    public WebElement userNameField;
    @FindBy (id="password")
    public WebElement passwordField;
    @FindBy (id="Login")
    public WebElement loginButton;




    public void login(String usernameStr, String passwordStr) {
        userNameField.sendKeys(usernameStr);
        passwordField.sendKeys(passwordStr);
        loginButton.click();

//        WebDriverWait wait = new WebDriverWait(DriverManager.get(), 10);
//        wait.until(ExpectedConditions.titleIs(ConfigurationReader.get("Home | Salesforce")));

    }
}
