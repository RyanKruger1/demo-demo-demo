package com.changeit;

import com.globalkinetic.groot.Groot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;

abstract class BaseTest {
    private static RemoteWebDriver driver;
    private Groot groot;
    private CustomConfig customConfig;

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup(Method method) throws IOException {
        groot = new Groot(this.getClass().getSimpleName() + "." + method.getName());
        customConfig = new CustomConfig(groot.getConfig().getProperties());
        driver = groot.getDriver();
        navigateToUrl();
    }

    public void navigateToUrl() {
        driver.get(groot.getConfig().getGrootTestUrl());
    }

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        groot.quit(result);
    }
}