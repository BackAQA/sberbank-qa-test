package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    private final SelenideElement menuButton = $("button.header-widget-menu-button");

    private final SelenideElement sberbankOnlineButton = $("button.header-widget-sbol-button__main", 1);

    public LoginPage openMenuAndClickSberbankOnline() {

        menuButton.shouldBe(Condition.visible).click();

        sberbankOnlineButton.shouldBe(Condition.visible).click();

        return new LoginPage();
    }
}
