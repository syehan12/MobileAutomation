package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class ProductPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;


    private final By productTitle =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/productTV"
            );

    private final By menuButton =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/menuIV"
            );


    private final By backpackTitle =
            AppiumBy.androidUIAutomator(
                    "new UiSelector()" +
                            ".resourceId(\"com.saucelabs.mydemoapp.android:id/titleTV\")" +
                            ".text(\"Sauce Labs Backpack\")"
            );


    private final By detailTitle =
            AppiumBy.androidUIAutomator(
                    "new UiSelector()" +
                            ".resourceId(\"com.saucelabs.mydemoapp.android:id/productTV\")" +
                            ".text(\"Sauce Labs Backpack\")"
            );

    private final By addToCartButton =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/cartBt"
            );

    public ProductPage(AndroidDriver driver) {

        this.driver = driver;

        this.wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20)
                );
    }


    public void waitUntilProductPageDisplayed() {

        System.out.println(
                "=== MENUNGGU PRODUCT PAGE ==="
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productTitle
                )
        );

        System.out.println(
                "=== PRODUCT PAGE TERBUKA ==="
        );
    }

    public void clickMenu() {

        System.out.println(
                "=== KLIK MENU ==="
        );

        WebElement menu =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                menuButton
                        )
                );

        menu.click();

        System.out.println(
                "=== MENU BERHASIL DIBUKA ==="
        );
    }


    public boolean isProductPageDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            productTitle
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }


    public void selectProduct() {

        System.out.println(
                "=== MENCARI SAUCE LABS BACKPACK ==="
        );

        WebElement backpack =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                backpackTitle
                        )
                );

        System.out.println(
                "=== SAUCE LABS BACKPACK DITEMUKAN ==="
        );

        System.out.println(
                "=== KLIK AREA PRODUK ==="
        );



        PointerInput finger =
                new PointerInput(
                        PointerInput.Kind.TOUCH,
                        "finger"
                );

        Sequence click =
                new Sequence(
                        finger,
                        1
                );

        click.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        285,
                        700
                )
        );

        click.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        click.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        driver.perform(
                Collections.singletonList(click)
        );

        System.out.println(
                "=== AREA PRODUK BERHASIL DIKLIK ==="
        );

        System.out.println(
                "=== MENUNGGU PRODUCT DETAIL ==="
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addToCartButton
                )
        );

        System.out.println(
                "=== PRODUCT DETAIL BERHASIL TERBUKA ==="
        );
    }


    public void clickAddToCart() {

        System.out.println(
                "=== MENCARI TOMBOL ADD TO CART ==="
        );

        WebElement addToCart =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                addToCartButton
                        )
                );

        addToCart.click();

        System.out.println(
                "=== ADD TO CART BERHASIL ==="
        );
    }
}