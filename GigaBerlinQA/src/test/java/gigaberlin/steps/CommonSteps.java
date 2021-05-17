package gigaberlin.steps;

import com.codeborne.selenide.Condition;
import gigaberlin.pages.GooglePage;
import io.cucumber.java8.En;
import static com.codeborne.selenide.Condition.have;
import static com.codeborne.selenide.Selenide.open;
import static gigaberlin.pages.BasePage.googleUrl;
import static gigaberlin.pages.GooglePage.googleLogo;
import static gigaberlin.pages.GooglePage.onTheGooglePage;

public class CommonSteps implements En {
    GooglePage googlePage;

    public CommonSteps() {

        Given("I am on the Google page", () -> {
           googlePage = open(googleUrl,GooglePage.class);
           googlePage.acceptCookies();
        });

        Then("I should see Google page", () -> {
            onTheGooglePage().should(have((Condition) googleLogo));
        });
    }
}
