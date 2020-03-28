package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.PropKey;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.jpetstore.util.PropKey.PORT;
import static com.jpetstore.util.PropKey.URL;

@Disabled
@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MyFirstTest extends DriverManager {

    @Test
    @DisplayName("This is my first selenium test!!!")
    void this_is_my_first_selenium_test() throws InterruptedException {

        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());

        String finalUrl = url + port;

        driver.get(finalUrl);
        Thread.sleep(2000);

    }
}
