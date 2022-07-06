package com.web.pages;

import com.web.base.BasePage;
import net.thucydides.core.annotations.Step;

public class HomePage extends BasePage {


    public static String userName="xpath=//*[@id=\"identifierId\"]";
    public static String nextBtn="xpath=//*[text()='Next']";




    @Step
    public void navigate(){
        open();
    }



    @Step
    public void enterUsername(String username) {
            getElement(userName).sendKeys(username);

    }


    @Step
    public void clickNextBtn() {
        checkElementIsClickable(getElement(nextBtn)).click();
    }





}
