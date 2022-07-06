package com.api.steps;

import com.api.serenity.FirstSerenityStep;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class First {

    @Steps
    FirstSerenityStep firstSerenityStep;

    @Given("^when api is available$")
    public void testing(){
       firstSerenityStep.firstStep();
    }

}
