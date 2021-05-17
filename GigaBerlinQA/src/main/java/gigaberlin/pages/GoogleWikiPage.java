package gigaberlin.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class GoogleWikiPage {

    @FindBy(xpath = "//h3[contains(.,'Wikipedia.org')]")
    public SelenideElement wikipediaLink;

    @FindBy(xpath = "//a[@id='logo']/img")
    public SelenideElement googleWikiLogo;

    public SelenideElement onTheGoogleSearchPage() {
        return googleWikiLogo;
    }


    public WikipediaPage goToTheWikipediaPage() {
        wikipediaLink.click();
        return page(WikipediaPage.class);
    }
}
