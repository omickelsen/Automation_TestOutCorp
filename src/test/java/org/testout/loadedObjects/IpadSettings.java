package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IpadSettings extends BaseComponent{

    private By  mailContactCalendarsElementBy = By.cssSelector("#siMailContactsCalendars");

    public IpadSettings(WebDriver driver) {
        super(driver);
    }


    public SettingsPanel clickMailContactCalendars() {
        WebElement mailContactCalendarsElement = findElementByWait(mailContactCalendarsElementBy, 3000);
        mailContactCalendarsElement.click();
        return getPageFactory().initElements(getDriver(), SettingsPanel.class);
    }
}
