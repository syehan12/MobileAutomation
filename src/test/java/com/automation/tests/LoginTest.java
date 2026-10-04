package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductPage;
import com.automation.pages.SidebarPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        ProductPage productPage =
                new ProductPage(driver);

        SidebarPage sidebarPage =
                new SidebarPage(driver);

        LoginPage loginPage =
                new LoginPage(driver);

        productPage.clickMenu();

        sidebarPage.clickLogin();

        loginPage.login(
                "bod@example.com",
                "10203040"
        );

        System.out.println(
                "=== LOGIN BERHASIL ==="
        );
    }
}