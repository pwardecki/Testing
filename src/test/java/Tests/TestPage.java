package Tests;


import Page.objects.Homepage;
import org.testng.annotations.Test;

public class TestPage extends Base {

    @Test
    public void testPageTests() {
        Homepage homepage = new Homepage();
        homepage.clickOnAcceptCookieButton();
    }
}
