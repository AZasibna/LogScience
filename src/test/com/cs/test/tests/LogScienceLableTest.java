package test.com.cs.test.tests;

import com.cs.automationframework.utilities.ConfigurationReader;
import com.cs.automationframework.utilities.Driver;
import com.cs.automationframework.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class LogScienceLableTest extends TestBase {

    @Test(priority = 0)
    public void logScienceLable() throws InterruptedException {

        extentLogger.pass("Verify page name " + driver.getTitle());
        extentLogger.pass("Open Custom Metadata Type URL ");
        driver.get(ConfigurationReader.getProperty("lodScienceURL"));
        Thread.sleep(6000);
        Driver.getDriver().switchTo().frame(pages.customMetadataType().iframe);//customMetadataType.iframe);
        String actualLable = pages.customMetadataType().logScienceLable.getText();//customMetadataType.logScienceLable.getText();
        String expectedLable = "Log_Settings";
        extentLogger.pass("Verifying Log_Settings lable");
        Assert.assertEquals(actualLable, expectedLable);
        extentLogger.pass("Log Science lable is " + actualLable);

    }

    @Test(priority = 1)
    public void devConsole() throws InterruptedException {

        extentLogger.pass("Openning Developer Console");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("developerConsoleUrl"));


    }
}



