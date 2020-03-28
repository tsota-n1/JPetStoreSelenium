package com.jpetstore.driver;

import com.jpetstore.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.jpetstore.util.Helper.getHubUrl;
import static com.jpetstore.util.Helper.isRemote;
import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;

    protected static WebDriver driver = null;

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    /**
     * Method to get WebDriver
     *
     * @return
     */
    public static WebDriver getDriver(){

        if(driver == null ){

            if(isRemote()){
                try {
                    driverThreadLocal.set(new RemoteWebDriver(new URL(getHubUrl()),
                          getBrowser().getBrowserCapabilities()));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else{
                driverThreadLocal.set(getBrowser().getWebDriver());
            }
        }

        driverThreadLocal.get().manage().timeouts()
                .implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);

        return driverThreadLocal.get();
    }


    /**
     * Method to quit WebDriver
     */
    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }


    /**
     * Determine browser
     * @return
     */
    private static BrowserType getBrowser(){

        BrowserType browserType = SystemPropertyHelper.getBrowserFromSystemVariable();

        if(browserType!=null){
            return browserType;
        }

        if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("CHROME")){

            return  BrowserType.CHROME;
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal())
                .equalsIgnoreCase("FIREFOX")){

            return BrowserType.FIREFOX;
        }
        else
        {
            return BrowserType.FIREFOX;
        }
    }
}
