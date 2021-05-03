package gigaberlin.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WikipediaPage {

    @FindBy(xpath = "//span[contains(.,'Wikipedia')]")
    public static SelenideElement wikipediaLogo;

    @FindBy(css = "#searchInput")
    public static SelenideElement wikipediaSearchBox;

    @FindBy(id = "searchLanguage")
    public static SelenideElement languageList;

    public SelenideElement onTheWikipediaPage() {
        return wikipediaLogo;
    }

    public void selectLanguageFromDropList() {
       languageList.selectOption("English");
    }

    public GigaBerlinPage searchForGigaBerlin(String keyWord) {
        $(wikipediaSearchBox).setValue(keyWord).pressEnter();
        return page(GigaBerlinPage.class);
    }
}
