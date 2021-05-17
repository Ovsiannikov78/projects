package gigaberlin.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class GooglePage  {

    @FindBy(xpath = "//*[@id=\"zV9nZe\"]/div")
    public static SelenideElement cookiesBtn;

    @FindBy(xpath = "//input[@name='q']")
    public static SelenideElement googleSearchBox;

    @FindBy(xpath = "//img[@alt='Google']")
    public static SelenideElement googleLogo;


    public void acceptCookies() {
        $(cookiesBtn).click();
    }

    public static SelenideElement onTheGooglePage() {
        return googleLogo;
    }


    public GoogleWikiPage searchForWikipediaPage(String wikiUrlText) {
        googleSearchBox.setValue(wikiUrlText).pressEnter();
        return page(GoogleWikiPage.class);
    }
}
