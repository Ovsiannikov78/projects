package gigaberlin.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GigaBerlinPage {

    @FindBy(id = "firstHeading")
    public static SelenideElement gigaBerlinConfirmationText;

    @FindBy(xpath = "//span[3]/span")
    public static SelenideElement coordinates;

    @FindBy(css = ".tocsection-4 .toctext")
    public static SelenideElement logistics;

    @FindBy(css = ".tocsection-5 .toctext")
    public static SelenideElement siteConcerns;

    @FindBy(xpath = "//tr[2]/td/a/img")
    public static SelenideElement miniMap;


    public SelenideElement onTheGigaBerlinPage() {
        return gigaBerlinConfirmationText;
    }

    public SelenideElement coordinatesEl() {
        return $(coordinates);
    }

    public SelenideElement textLinkEl(String textLink) {
        return $(By.xpath("//span[contains(.,'" + textLink + "')]"));
    }

    public GoogleMapPage clickMiniMap() {
        $(miniMap).click();
        return page(GoogleMapPage.class);
    }


}
