package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.pages.BasePage;
import com.jpetstore.pages.LoginPage;
import com.jpetstore.steps.JPetStoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestListener.class)
@DisplayName("Login Tests")
public class LoginTest extends JPetStoreSteps {


    //Annotation for retrying failing tests
    //@RepeatedIfExceptionsTest(repeats = 3)

    @Tag(SMOKE)
    @Test
    @DisplayName("As a valid user, a user must be able to login with valid credentials.")
    @Description("Logging into the app via sign on page")
    void doLogin(){
        navigateToApp();
        navigateToSignOnPage();
        doLogin("j2ee","j2ee");

        assertEquals("Welcome ABC!", getGreetingMessage());

       //Soft Assertion
//        assertAll(
//                () -> assertEquals("Welcome ABC!", getGreetingMessage()),
//                () -> assertEquals("Welcome ABC!", getGreetingMessage())
//        );

    }


    @Nested
    class NegativeTests{

        @DisplayName("User must not be able to login with invalid credentials")
        @Test
        void invalidLogin(){

            navigateToApp();
            navigateToSignOnPage();
            doLogin("j2ee","j233434");



            assertEquals("Invalid username or password. Signon failed.",
                    getMessageOnInvalidLogin());
        }

        @Nested
        class NegativeTestsLogin{
            @DisplayName("User must not be able to login with invalid credentials")
            @Test
            void invalidLogin(){

                navigateToApp();
                navigateToSignOnPage();
                doLogin("j2ee","j233434");

                assertEquals("Invalid username or password. Signon failed.",
                        getMessageOnInvalidLogin());
            }
        }
    }


}
