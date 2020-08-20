package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPanel extends BaseComponent{

    private By userSubMenuBy = By.cssSelector("#gClient [data-typename='SettingsItemSubMenu']");
    private By userBy = By.cssSelector("#siAccount\\.Grid\\.rectClickArea");
    private By wifiBy = By.cssSelector("#siWiFi");

    public SettingsPanel(WebDriver driver) {
        super(driver);
    }

    public AccountInfo clickUserAccount() {
        WebElement userSubMenuElement = findElementByWait(userSubMenuBy, 2000);
        userSubMenuElement.click();
        WebElement userElement = findElementByWait(userBy, 2000);
        userElement.click();
        return getPageFactory().initElements(getDriver(), AccountInfo.class);
    }

    public WiFiSettings selectWifi() {
        getDriver().findElement(wifiBy).click();
        return getPageFactory().initElements(getDriver(), WiFiSettings.class);
    }
}
