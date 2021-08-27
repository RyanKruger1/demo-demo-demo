package com.changeit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertNotNull;

public class CustomUrlSampleTest extends BaseTest {

    @BeforeMethod
    @Override
    public void setup(Method method) throws IOException {
        super.setup(method);
    }

    @Override
    public void navigateToUrl() {
        getDriver().get(getCustomConfig().getCustomGrootTestUrl());
    }

    /**
     * Enabling this test requires adding the below property to the project's groot.properties:
     * groot.test.url.custom=http://appium.io
     */
    @Test(enabled = false)
    public void testAppiumDownloadButton() {
        PageObjSample page = new PageObjSample(getDriver());
        page.download();
        assertNotNull(getDriver().getTitle());
    }
}