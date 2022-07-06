package steps;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import serenity.FirstSerenityStep;

public class First {

    @Steps
    FirstSerenityStep firstSerenityStep;

    @Given("^when api is available$")
    public void testing(){
       firstSerenityStep.firstStep();
    }

}
