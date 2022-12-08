package allure.test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static allure.data.Constants.issueName;
import static allure.data.Constants.repository;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Feature("Allure")
@Story("Тесты с применением lambda steps")
public class LambdaStepsTest extends BaseTest {

    @Owner("d.kuznetsov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка названия Issue в репозитории")
    @Test
    public void test01() {

        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Найти репозиторий с помощью поиска " + repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(repository);
            $(".header-search-input").submit();
        });
        step("Нажать на ссылку репозитория " + repository, () -> {
            $(linkText(repository)).click();
        });
        step("Открыть таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Убедиться в наличии Issue " + issueName, () -> {
            $(withText(issueName)).should(visible);
        });
    }
}