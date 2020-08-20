package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IpadSimulation extends BaseComponent{


    private By iPadBy = By.cssSelector("#Desktop");;
    private By settingsBy = By.cssSelector(".clsFrameworkElement#wpDesktop\\.DesktopIcon15");
    private By doneBy = By.cssSelector("#bDone");

    public IpadSimulation(WebDriver driver) {
        super(driver);
        getPageFactory().initElements(driver, this);
    }

    public IpadSettings clickSettings() {
        WebElement iPadMainElement = findElementByWait(iPadBy, 5000);
        iPadMainElement.findElement(settingsBy).click();
        return getPageFactory().initElements(getDriver(), IpadSettings.class);
    }


    public void clickDone() {
        getDriver().findElement(doneBy).click();
    }
}
