package com.changeit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertNotNull;

public class SampleTest1 extends BaseTest {

    @BeforeMethod
    @Override
    public void setup(Method method) throws IOException {
        super.setup(method);
    }

    @Test
    public void testSearchBar() {
        PageObjSample page = new PageObjSample(getDriver());
        page.search("Hello");
        assertNotNull(page.searchBar);
    }
}