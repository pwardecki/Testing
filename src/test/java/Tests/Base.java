package Tests;

import Service.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    @BeforeMethod
    public void beforeTest() {
        Driver.getDriver();
        Driver.setInitialConfiguration();
        Driver.navigateToPage("http://www.olx.pl");
    }

    @AfterMethod
    public void afterTest() {
        Driver.disposeDriver();
    }
}
