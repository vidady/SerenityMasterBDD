package com.web.base;

import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import com.web.utilities.CommonUtils;

public class BasePage extends CommonUtils {


    @Managed (clearCookies = ClearCookiesPolicy.BeforeEachTest)
    WebDriver driver;

    static{
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/"+"src/main/resources/drivers/msedgedriver.exe");
    }



    /************************* COMMON BUSINESS SPECIFIC FUNCTIONS *********************************/

}
