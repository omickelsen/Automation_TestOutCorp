package org.testout;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testout.loadedObjects.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSimulation extends TestCore{

    public static final String PERFECT_SCORE = "1 of 1 (100%)";
    private WebDriver driver;
    private IpadSimulation ipadSimulation;

    @Before
    public void setUp()  {
        driver = getWebDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        ipadSimulation = new IpadSimulation(driver);
    }

    @Test
    public void testSSLandPort()  {
        /*
        Setting, accounts, account advanced, ssl, port, done.
        */

        IpadSettings iPadSettings = ipadSimulation.clickSettings();
        SettingsPanel settingsPanel = iPadSettings.clickMailContactCalendars();
        AccountInfo accountInfo = settingsPanel.clickUserAccount();
        AdvancedAccountSettings advancedAccountSettings = accountInfo.selectAdvanced();
        advancedAccountSettings.useSSL();
        assertEquals("Incorrect server port on using SSL", "993", advancedAccountSettings.getPort());
        accountInfo = advancedAccountSettings.exitAdvancedSettings();
        accountInfo.selectDone();


        /*Wifi and password entry and report*/

        WiFiSettings wiFiSettings = settingsPanel.selectWifi();
        PasswordForm passwordForm = wiFiSettings.selectCorpNet();
        passwordForm.enterPassword("@CorpNetWeRSecure!&");
        ipadSimulation.clickDone();
        //switch to iFrame and check Results
        LabReport labReport = new LabReport(driver);
        String actualScore = labReport.getScore();
        assertTrue("Incorrect score. Expected :" +  PERFECT_SCORE + "Actual: "
                + actualScore, actualScore.contains(PERFECT_SCORE));

    }

}
