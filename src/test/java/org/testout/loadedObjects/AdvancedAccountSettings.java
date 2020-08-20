package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedAccountSettings extends BaseComponent{

    private By portBy = By.cssSelector("#tbServerPort");
    private By exitBy = By.cssSelector("#btnAccount");
    private By sslSliderBy = By.cssSelector("#siUseSSL\\.Grid\\.tbOnOff");

    public AdvancedAccountSettings(WebDriver driver) {
        super(driver);
    }


    public void useSSL() {
        WebElement sslSlider = findElementByWait(sslSliderBy, 5000);
        getActions().dragAndDropBy(sslSlider,40,0).perform();
    }

    public String getPort() {
        WebElement element = getDriver().findElement(portBy);
        return element.getAttribute("value");
    }

    public AccountInfo exitAdvancedSettings() {
        WebElement exitElement = findElementByWait(exitBy, 5000);
        exitElement.click();
        return getPageFactory().initElements(getDriver(), AccountInfo.class);
    }



}
