package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SidebarPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By loginMenu =
            AppiumBy.accessibilityId(
                    "Login Menu Item"
            );

    public SidebarPage(AndroidDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    public void clickLogin() {

        System.out.println(
                "Mencari menu Login..."
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginMenu
                )
        ).click();

        System.out.println(
                "Menu Login berhasil diklik."
        );
    }
}