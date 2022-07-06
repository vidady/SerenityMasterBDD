package com.web.cucumbersteps;

import com.web.pages.HomePage;
import com.web.pages.PasswordPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;



public class FirstFeatureSteps {

    @Steps
    HomePage homePage;

    @Steps
    PasswordPage passwordPage;

    @Given("^When user (.*) is on homepage with password (.*)$")
    public void when_user_is_on_homepage(String username,String password) {
        System.out.println("When "+username+" is on homepage with "+password);
        homePage.enterUsername(username);
        homePage.clickNextBtn();
        passwordPage.enterPasswordToThePasswordField(password);



    }
    @Then("^verify login of google$")
    public void verify_login_of_google() {
        System.out.println("verify login of google");
    }


    @Given("^Navigate to application")
    public void navigateToApp(){
        homePage.navigate();
    }




}
