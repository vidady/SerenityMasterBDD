package com.web.utilities;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.HtmlTable;
import net.thucydides.core.webelements.Checkbox;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.SECONDS;

public class CommonUtils extends PageObject {

    private static final int EXPLICIT_TIME=10;
    private static final int IMPLICIT_TIME=5;
    private static final int POLL_TIME=10;

    public WebElementFacade checkElementIsVisible(WebElement element){
       return (WebElementFacade) waitForCondition().withTimeout(Duration.ofSeconds(EXPLICIT_TIME)).pollingEvery(Duration.ofSeconds(POLL_TIME)).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElementFacade checkPresenceOfElement(String locator){
        return (WebElementFacade) waitForCondition().withTimeout(Duration.ofSeconds(EXPLICIT_TIME)).pollingEvery(Duration.ofSeconds(POLL_TIME)).until(ExpectedConditions.presenceOfElementLocated(getBy(locator)));
    }

    public WebElementFacade checkElementIsClickable(WebElement element){
        return (WebElementFacade) waitForCondition().withTimeout(Duration.ofSeconds(EXPLICIT_TIME)).pollingEvery(Duration.ofSeconds(POLL_TIME)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElementFacade waitForElement(int waitTime, String locator){
        return withTimeoutOf(Duration.ofSeconds(waitTime)).find(getBy(locator));
    }

    public WebElementFacade getElement(String locator) {
        try {
            return find(getBy(locator));
        } catch (NoSuchElementException e) {
            e.getMessage();
        }

        return null;
    }

    // Finding Multiple Elements
    public List<WebElementFacade> getElements(String locator) {

        try {

            return findAll(getBy(locator));

        } catch (NoSuchElementException e) {

            e.getMessage();

        }

        return null;
    }

    private By getBy(String locator) {

        By by = null;

        try {

            if (locator.startsWith("id=")) {

                locator = locator.substring(3);
                by = By.id(locator);
            } else if (locator.startsWith("xpath=")) {

                locator = locator.substring(6);
                by = By.xpath(locator);
            } else if (locator.startsWith("css=")) {

                locator = locator.substring(4);
                by = By.cssSelector(locator);
            } else if (locator.startsWith("name=")) {

                locator = locator.substring(5);
                by = By.name(locator);
            } else if (locator.startsWith("link=")) {

                locator = locator.substring(5);
                by = By.linkText(locator);
            }
            return by;

        } catch (Throwable t) {

            t.getMessage();
        }

        return null;

    }

    public void assertData(Object expectedValue,Object actualValue){
        Serenity.reportThat("Verification of expected against actual value",()-> Assert.assertEquals(expectedValue,actualValue));
    }

    public void setCustomImplicitTimeout(int seconds){
        setImplicitTimeout(seconds, SECONDS);
    }

    public void setFrameworkImplicitTimeout(){
        setImplicitTimeout(IMPLICIT_TIME, SECONDS);
    }

    public void selectDropdownOption(String dropDownElement,String childOption){
        getElement(dropDownElement).selectByValue(childOption);
    }

    public ListOfWebElementFacades getListOfDropDownOptions(String dropDownElement,String childOptionLocator){
       return getElement(dropDownElement).thenFindAll((getBy(childOptionLocator)));
    }

    public void selectCheckBox(String checkBoxLocator,boolean expectedFlag){
        new Checkbox(getElement(checkBoxLocator)).setChecked(expectedFlag);
    }

    public boolean verifyCheckBoxState(String checkBoxLocator,boolean expectedFlag){
        return (new Checkbox(getElement(checkBoxLocator)).isChecked()==expectedFlag)?true:false;
    }

    public void mouseOverToElement(String locator){
        withAction().moveToElement(getElement(locator)).build().perform();
    }

    public void moveSliderElement(String locator,int xOffset,int yOffset){
        withAction().dragAndDropBy(getElement(locator),xOffset,yOffset).build().perform();
    }

    public void dragAndDropElement(String sourceLocator,String targetLocator){
        withAction().dragAndDrop(getElement(sourceLocator),getElement(targetLocator)).build().perform();
    }

    public void rightClickToElement(String locator){
        withAction().contextClick(getElement(locator)).build().perform();
    }

    public void click(String locator) {
        waitFor(getElement(locator)).click();
    }

    public void switchToFrame(String frameName){
        getDriver().switchTo().frame(frameName);
    }

    public void switchToDefaultFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void switchToWindow(int windowIndex){
        ArrayList<String> windowHandles= (ArrayList<String>) getDriver().getWindowHandles();
        getDriver().switchTo().window(windowHandles.get(windowIndex));
    }

    public void javascriptElementClick(String locator){
        getJavascriptExecutorFacade().executeScript("arguments[0].click();",getElement(locator));
    }

    public void uploadFile(String uploadLocator, String file){
        upload(file).to(getElement(uploadLocator));
    }

    public List<Map<Object, String>> getTableData(By tableLocator){
        HtmlTable htmlTable=new HtmlTable(find(tableLocator));
        return htmlTable.getRows();
    }

    public void type(String locator, String value) {
        waitFor(getElement(locator)).sendKeys(value);
    }

    public String getText(String locator) {
        return waitFor(getElement(locator)).getText();
    }

    public void moveMouseTo(String locator) {
        WebElement moveTo = waitFor(getElement(locator));
        withAction().moveToElement(moveTo).perform();
    }








}
