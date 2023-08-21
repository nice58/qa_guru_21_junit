package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class KinopoiskFilmSearchTest extends BaseTest {

    @BeforeEach
    void setUp() {
        open("https://www.kinopoisk.ru/");
    }

    static Stream<String> searchFilmString() {
        return Stream.of("Барби", "Оппенгеймер");
    }

    @Tags({
            @Tag("web"),
            @Tag("search")
    })

    @DisplayName("Проверка поиска в kinopoisk.ru с помощью @MethodSource")
    @ParameterizedTest(name = "После поиска {0} открылась страница с информацией о фильме {0}")
    @MethodSource("searchFilmString")
    public void successfulSearch(String searchFilmString) {
        $("[type='text']").setValue(searchFilmString);
        $(".styles_mainLink__A4Xkh").click();
        $(".styles_header__mzj3d").shouldHave(text(searchFilmString));
    }
}
