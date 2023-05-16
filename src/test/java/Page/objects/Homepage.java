package Page.objects;

import Service.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    @FindBy(css="#onetrust-button-group #onetrust-accept-btn-handler")
    private WebElement acceptCookieButton;

    public Homepage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public Homepage clickOnAcceptCookieButton() {
        acceptCookieButton.click();
        return new Homepage();
    }
}
