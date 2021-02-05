package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Description("Перенести прямоугольник А на место В")
    @Test
    void swapABTest() {
        //не работает
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $$("#columns").shouldHave(exactTexts("B A"));
//тоже не работает
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(300, 200).release().perform();
        $$("#columns").shouldHave(exactTexts("B A"));
    }
}