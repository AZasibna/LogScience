package com.cs.automationframework.utilities;

import com.cs.automationframework.pageobjects.CustomMetadataType;
import com.cs.automationframework.pageobjects.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private CustomMetadataType customMetadataType;

    public LoginPage loginPage(){
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    public CustomMetadataType customMetadataType(){
        if(customMetadataType == null){
           customMetadataType = new CustomMetadataType();
        }
        return customMetadataType;
    }
}
