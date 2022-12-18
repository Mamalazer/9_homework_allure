package allure.page;

import io.qameta.allure.Step;

import static allure.data.Constants.url;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String searchField = ".header-search-input";
    private final String headerElement = ".HeaderMenu-item button";
    private final String headerMenuLink = ".HeaderMenu-dropdown-link";

    @Step("Открыть главную страницу")
    public static MainPage openMainPage() {
        open(url);
        return new MainPage();
    }

    @Step("Найти репозиторий с именем {name}")
    public SearchResultPage searchRepository(String name) {
        $(searchField).click();
        $(searchField).setValue(name);
        $(searchField).submit();
        return new SearchResultPage();
    }

    @Step("Навести мышь на на кнопку {buttonName} в header")
    public MainPage hoverButtonInHeader(String buttonName) {
        $$(headerElement).filter(text(buttonName))
                .first()
                .hover();
        return this;
    }

    @Step("Перейти по ссылке из выпадающего списка header меню")
    public void openHeaderLinkByName(String linkName, String expectedPageTitle) {
        $$(headerMenuLink).filter(text(linkName))
                .first()
                .click();
        $(byText(expectedPageTitle)).shouldBe(visible);
    }
}
