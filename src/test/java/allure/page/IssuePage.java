package allure.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IssuePage {

    private final String createIssueButton = "//*[normalize-space(text()) = 'New issue']";

    public IssuePage() {
        $x(createIssueButton).shouldBe(visible);
    }

    @Step("Убедиться, что на странице присутствует issue c названием {name}")
    public IssuePage checkIssueByName(String name) {
        $(withText(name)).should(exist);
        return this;
    }
}
