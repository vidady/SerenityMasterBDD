package com.web.pages;

import com.web.base.BasePage;
import net.thucydides.core.annotations.Step;

public class PasswordPage extends BasePage {


    public static String passWord="xpath=//*[@id=\"password\"]/div[1]/div/div[1]/input";


    @Step
    public void enterPasswordToThePasswordField(String password) {
        getElement(passWord).sendKeys(password);


    }
}
