package org.testout.loadedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordForm extends BaseComponent{

    private By passwordBy = By.cssSelector("[data-typename='PasswordBox']");
    private By joinBy = By.cssSelector("div[id$='btnJoin'");

    public PasswordForm(WebDriver driver) {
        super(driver);
    }

    public void enterPassword(String password) {
        getDriver().findElement(passwordBy).sendKeys(password);
        selectJoin();
    }

    private void selectJoin() {
        getDriver().findElement(joinBy).click();}
}
