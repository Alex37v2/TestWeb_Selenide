package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    @Test
    void mustRegisterAnAccount() {
        open("http://localhost:9999");
        $("span[data-test-id='city'] input").setValue("Владивосток");
        $("span[data-test-id='date'] input").setValue("04.02.2023");
        $("span[data-test-id='name'] input").setValue("Кристина Кактус-Песикова");
        $("span[data-test-id='phone'] input").setValue("+79200000000");
        $("label[data-test-id='agreement']").click();
        $x("//span[@class='button__text']").click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(byText("Встреча успешно забронирована на")).shouldBe(visible, Duration.ofSeconds(15));
        $(byText("04.02.2023")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
