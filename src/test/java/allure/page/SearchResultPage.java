package allure.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.openqa.selenium.By.linkText;

public class SearchResultPage {

    private final String pageTittle = "//*[contains(text(), 'repository result')]";

    public SearchResultPage() {
        $x(pageTittle).shouldBe(visible);
    }

    @Step("Выбрать репозиторий с именем {name}")
    public RepositoryPage chooseRepository(String name) {
        $(linkText(name)).click();
        return new RepositoryPage();
    }
}
