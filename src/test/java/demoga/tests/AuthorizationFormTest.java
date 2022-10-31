package demoga.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demoga.pages.RegistrationFormPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static demoga.testData.UserInfo.*;
import static io.qameta.allure.Allure.step;

public class AuthorizationFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    @DisplayName("Filling the form with input data")
    @Owner("Dinara")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Filling the form with random user data")
    @Link(value = "testing form", url="https://demoqa.com")
    void fillFormTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill the form with user Info", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setNumber(number)
                    .setBirthDate(day, month, year)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .uploadFile(path)
                    .setAddress(address)
                    .setStateAndCity(state, city)
                    .submit();
        });
        step("Check the filled form results", () -> {
            registrationFormPage.checkResultTableVisibility()
                    .checkResultTableData(firstName, lastName, email, number, date, gender,
                            pic, address, subject, hobby, state, city);
        });
    }

    @Test
    @DisplayName("Filling the form with minimum data")
    @Owner("Dinara")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Filling the form with the minimum required input data")
    @Link(value = "testing form", url="https://demoqa.com")
    void fillFormWithMinimumTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill the form with user Info", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setNumber(number)
                    .submit();
        });
        step("Check the filled form results", () -> {
            registrationFormPage.checkResultTableVisibility()
                    .checkResultTableData(firstName, lastName, number, gender);
        });
    }
}
