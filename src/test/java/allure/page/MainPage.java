package allure.page;

import io.qameta.allure.Step;

import static allure.data.Constants.url;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final String searchField = ".header-search-input";

    @Step("Открыть главную страницу")
    public static MainPage openMainPage() {
        open(url);
        return new MainPage();
    }

    @Step("Найти репозиторий с именем {name}")
    public SearchResultPage searchRepository(String name) {
        $(searchField).click();
        $(searchField).sendKeys(name);
        $(searchField).submit();
        return new SearchResultPage();
    }
}
