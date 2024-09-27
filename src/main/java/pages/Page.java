package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {
    public WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

}
