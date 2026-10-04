package com.automation.base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        System.out.println("================================");
        System.out.println("MEMULAI AUTOMATION TEST");
        System.out.println("================================");

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setAppPackage(
                "com.saucelabs.mydemoapp.android"
        );

        options.setAutoGrantPermissions(true);

        URL appiumServer = URI
                .create("http://127.0.0.1:4723")
                .toURL();

        driver = new AndroidDriver(
                appiumServer,
                options
        );


        System.out.println(
                "=== CEK POPUP COMPATIBILITY ==="
        );

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10)
                );

        By dontShowAgainButton =
                AppiumBy.id(
                        "android:id/button1"
                );

        try {

            WebElement popupButton =
                    wait.until(
                            ExpectedConditions.elementToBeClickable(
                                    dontShowAgainButton
                            )
                    );

            System.out.println(
                    "=== POPUP DITEMUKAN ==="
            );

            popupButton.click();

            System.out.println(
                    "=== DON'T SHOW AGAIN BERHASIL DIKLIK ==="
            );

        } catch (Exception e) {

            System.out.println(
                    "=== POPUP TIDAK MUNCUL, TEST DILANJUTKAN ==="
            );
        }

        System.out.println(
                "=== TEST DILANJUTKAN ==="
        );
    }
    @AfterMethod
    public void tearDown() {

        System.out.println(
                "=== MENUTUP SESSION APPIUM ==="
        );

        if (driver != null) {
            driver.quit();
        }

        System.out.println(
                "=== SESSION SELESAI ==="
        );
    }
}