package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class all {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "F:\\CDIP\\selenum_testing\\orangrHrm\\src\\main\\resources\\chromedriver.exe");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Login as admin
            WebElement usernameField = driver.findElement(By.id("txtUsername"));
            WebElement passwordField = driver.findElement(By.id("txtPassword"));
            WebElement loginButton = driver.findElement(By.id("btnLogin"));

            usernameField.sendKeys("Admin");
            passwordField.sendKeys("admin123");
            loginButton.click();

            // Navigate to PIM > Add Employee
            WebElement pimTab = driver.findElement(By.id("menu_pim_viewPimModule"));
            pimTab.click();
            WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmployeeButton.click();

            // Create a new employee
            WebElement firstNameField = driver.findElement(By.id("firstName"));
            WebElement lastNameField = driver.findElement(By.id("lastName"));
            WebElement saveButton = driver.findElement(By.id("btnSave"));

            String firstName = "John";
            String lastName = "Doe";
            firstNameField.sendKeys(firstName);
            lastNameField.sendKeys(lastName);
            saveButton.click();

            // Navigate to PIM > Employee List
            WebElement employeeListButton = driver.findElement(By.id("menu_pim_viewEmployeeList"));
            employeeListButton.click();

            // Search for the employee by name
            WebElement searchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
            WebElement searchButton = driver.findElement(By.id("searchBtn"));

            searchNameField.sendKeys(firstName + " " + lastName);
            searchButton.click();

            // Verify the employee appears in the search results
            WebElement employeeName = driver.findElement(By.xpath("//a[contains(text(), '" + firstName + " " + lastName + "')]"));
            if (employeeName.isDisplayed()) {
                System.out.println("Employee found in the list.");
            } else {
                System.out.println("Employee not found in the list.");
            }

            // Logout
            WebElement welcomeMenu = driver.findElement(By.id("welcome"));
            welcomeMenu.click();
            WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
            logoutLink.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
    }

