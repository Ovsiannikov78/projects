package gigaberlin.steps;

import gigaberlin.pages.*;
import io.cucumber.java8.En;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class GigaBerlinSteps implements En {
    GoogleMapPage googleMapPage;
    GigaBerlinPage gigaBerlinPage;
    GooglePage googlePage;
    GoogleWikiPage googleWikiPage;
    WikipediaPage wikipediaPage;

    public GigaBerlinSteps() {

        When("I search for {} on Google page", (String searchText) -> {
            googlePage = page(GooglePage.class);
            googleWikiPage = googlePage.searchForWikipediaPage(searchText);
        });

        Then("I see the Google search result page", () -> {
            googleWikiPage.onTheGoogleSearchPage().should();
        });



        When("I click on the upper wikipedia link", () -> {
            googleWikiPage = page(GoogleWikiPage.class);
            wikipediaPage = googleWikiPage.goToTheWikipediaPage();
        });
        Then("I see the Wikipedia page", () -> {
            wikipediaPage.onTheWikipediaPage().shouldHave(text("Wikipedia"));
        });



        When("I search for {} on the Wikipedia page", (String searchText) -> {
            wikipediaPage = page(WikipediaPage.class);
            wikipediaPage.selectLanguageFromDropList();
            gigaBerlinPage = wikipediaPage.searchForGigaBerlin(searchText);
        });
        Then("I see the Giga Berlin page", () -> {
            gigaBerlinPage.onTheGigaBerlinPage().should(have(text("Giga Berlin")));
        });
        Then("I see Coordinates of the location", () -> {
            gigaBerlinPage.coordinatesEl().should(have(text("52.4°N 13.8°E")));
        });
        Then("I see Logistics data", () -> {
            gigaBerlinPage.logisticsEl().should(have(text("Logistics")));
        });
        Then("I see Site concerns data", () -> {
            gigaBerlinPage.siteConcernsEl().should(have(text("Site concerns")));
        });


        When("I click on the mini map on the Giga Berlin page", () -> {
            gigaBerlinPage = page(GigaBerlinPage.class);
            googleMapPage = gigaBerlinPage.clickMiniMap();
        });
        Then("I see the Google Map page with {} location", (String locationText) -> {
            googleMapPage.locationGigaBerlin();
            googleMapPage.checkLocationText().should(have(text(locationText)));
        });
    }
}
