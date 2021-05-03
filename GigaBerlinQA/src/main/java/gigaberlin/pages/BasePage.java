package gigaberlin.pages;

import gigaberlin.util.PropertiesLoader;
import org.openqa.selenium.WebDriver;

public class BasePage {

    public static String googleUrl = PropertiesLoader.loadProperty("urlGoogle");

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
