package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductPage;
import com.automation.pages.SidebarPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndAddToCartTest extends BaseTest {

    @Test
    public void loginAndAddToCartTest() {

        ProductPage productPage =
                new ProductPage(driver);

        SidebarPage sidebarPage =
                new SidebarPage(driver);

        LoginPage loginPage =
                new LoginPage(driver);

        System.out.println(
                "=== MULAI TEST ==="
        );


        productPage.waitUntilProductPageDisplayed();


        productPage.clickMenu();


        sidebarPage.clickLogin();

        loginPage.login(
                "bod@example.com",
                "10203040"
        );


        Assert.assertTrue(
                productPage.isProductPageDisplayed(),
                "Login gagal!"
        );

        System.out.println(
                "=== LOGIN BERHASIL ==="
        );


        System.out.println(
                "=== KLIK SAUCE LABS BACKPACK ==="
        );

        productPage.selectProduct();


        System.out.println(
                "=== KLIK ADD TO CART ==="
        );

        productPage.clickAddToCart();


        System.out.println(
                "=== TEST BERHASIL ==="
        );
        System.out.println(
                "LOGIN → PILIH PRODUCT → DETAIL PRODUCT → ADD TO CART"
        );
    }
}