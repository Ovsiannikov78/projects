package gigaberlin.pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class GoogleMapPage {

    @FindBy(xpath = "//img[@title='Giga Berlin']")
    public static SelenideElement location;

    @FindBy(css = ".marker-title")
    public static SelenideElement locationText;

    public void locationGigaBerlin() {
        $(location).click();
    }
    public SelenideElement checkLocationText() {
      return  $(locationText);
    }
}
