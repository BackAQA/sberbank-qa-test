package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginByPasswordBtn = $("button[aria-label='По логину и паролю']");

    private final SelenideElement loginInput = $("input[name='login'][data-testid='input-text']");

    private final SelenideElement passwordInput = $("input[name='password']");

    private final SelenideElement submitBtn = $("button[data-testid='button-continue']");

    private final SelenideElement errorBlock = $("div[id='password-error'] p");

    private final SelenideElement acceptCookieBtn = $("[data-testid='cookie-policy-inner'] button[aria-label='Принять']");

    public LoginPage clickLoginByPassword() {
        loginByPasswordBtn.shouldBe(Condition.visible).click();
        return this;
    }

    public LoginPage enterLogin(String login) {
        loginInput.shouldBe(Condition.visible).setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.shouldBe(Condition.visible).setValue(password);
        return this;
    }

    public LoginPage clickSubmit() {
        if (acceptCookieBtn.isDisplayed()) {
            acceptCookieBtn.click();
        }

        submitBtn.shouldBe(Condition.visible).click();
        return this;
    }

    public String getErrorMessage() {
        errorBlock.shouldHave(Condition.text("Неверный логин или пароль"));
        return errorBlock.getText();
    }
}
