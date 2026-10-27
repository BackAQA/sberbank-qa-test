package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Config.SBERBANK_URL;

public class SberbankLoginTest {

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open(SBERBANK_URL);
    }

    @Test
    @Description("Проверка отображения ошибки при неверной авторизации")
    public void testInvalidLogin() {
        MainPage mainPage = new MainPage();
        var error = mainPage.openMenuAndClickSberbankOnline()
                .clickLoginByPassword()
                .enterLogin("testuser12345")
                .enterPassword("invalidPass123")
                .clickSubmit()
                .getErrorMessage();

        assertTrue(error.contains("Неверный логин"),
                "Ожидалась ошибка авторизации, но получили: " + error);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
