package com.automation.tests;

import com.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumConnectionTest extends BaseTest {

    @Test
    public void verifyAppOpened() {

        Assert.assertNotNull(driver);

        System.out.println("App berhasil dibuka!");
    }
}