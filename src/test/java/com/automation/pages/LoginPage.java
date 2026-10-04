package com.automation.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private final By usernameField =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/nameET"
            );

    private final By passwordField =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/passwordET"
            );

    private final By loginButton =
            AppiumBy.id(
                    "com.saucelabs.mydemoapp.android:id/loginBtn"
            );

    public LoginPage(AndroidDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );
    }

    public void enterUsername(String username) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                usernameField
                        )
                );

        element.click();
        element.clear();
        element.sendKeys(username);

        System.out.println(
                "Username berhasil diisi."
        );
    }

    public void enterPassword(String password) {

        WebElement element =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                passwordField
                        )
                );

        element.click();
        element.clear();
        element.sendKeys(password);

        System.out.println(
                "Password berhasil diisi."
        );
    }

    public void clickLogin() {

        WebElement element =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                loginButton
                        )
                );

        element.click();

        System.out.println(
                "Tombol Login berhasil diklik."
        );
    }

    public void login(
            String username,
            String password
    ) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}