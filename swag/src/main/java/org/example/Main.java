package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;
import java.net.http.WebSocket;
import java.sql.Driver;

public class Main {
    public static void main(String[] args) {
       System.setProperty("WebDriver.chrome.driver","F:\\CDIP\\selenum_testing\\swag\\src\\main\\resources\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();


    }
}