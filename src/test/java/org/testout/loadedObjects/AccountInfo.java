package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInfo extends BaseComponent{

    @FindBy(css= ".clsFrameworkElement [data-typename='ScrollViewer']")
    private By advancedBy = By.cssSelector("div[id$='spAccount\\.PropertyGroup2']");
    private By doneBy = By.cssSelector("div[id$='btnDone']");

    public AccountInfo(WebDriver driver) {
        super(driver);
    }

    public AdvancedAccountSettings selectAdvanced() {
        WebElement advancedElement = findElementByWait(advancedBy, 3000);
        advancedElement.click();
        return getPageFactory().initElements(getDriver(), AdvancedAccountSettings.class);
    }

    public void selectDone() {
        WebElement doneElement = findElementByWait(doneBy, 3000);
        doneElement.click();
    }
}
