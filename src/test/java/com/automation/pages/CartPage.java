package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    // Judul halaman Cart
    private final By cartTitle =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/productTV");

    // Nama produk yang masuk ke cart
    private final By productInCart =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/titleTV");


    private final By cartBadge =
            AppiumBy.id("com.saucelabs.mydemoapp.android:id/plusIV");


    public CartPage(AndroidDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }


    public boolean isCartDisplayed() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            cartTitle
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    public boolean isProductAdded() {

        try {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            productInCart
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }


    public String getCartBadgeText() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cartBadge
                )
        ).getText();
    }
}