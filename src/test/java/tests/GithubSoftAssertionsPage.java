package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSoftAssertionsPage {

    @Description("Открыть страницу SoftAssertions в github/selenide и проверить что внутри есть пример кода для JUnit5")
    @Test
    void softAssertionsTest() {
        open("https://github.com/");
        $("[name=q]").val("Selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("h1").shouldHave(text("selenide / selenide"));
        $(byText("Wiki")).click();
        $("#wiki-body").shouldHave(text("Welcome to the selenide wiki!"));
        $$(".Box-row").findBy(text("SoftAssertions")).click();
        $(".page").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
