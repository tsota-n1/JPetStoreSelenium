package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MySecondTest extends DriverManager {

    @Disabled
    @Test
    @DisplayName("This is my first selenium test!!!")
    void this_is_my_first_selenium_test() throws InterruptedException {


        String url = prop.getProperty("url");
        String port = prop.getProperty("port");
        String finalUrl = url + port;

        driver.get(finalUrl);
        driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/input[1]")).sendKeys("Hello");
        Thread.sleep(2000);

    }

}
