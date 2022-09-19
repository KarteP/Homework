package com.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {  

    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
    WebDriver driver = new ChromeDriver();
      
    // Launch website  
    driver.navigate().to("http://localhost:8080/");
 
    // Register
    driver.findElement(By.className("register")).click();

    String actualTitleRegister = driver.getTitle();
    System.out.println("The title of the webpage:  " + actualTitleRegister);
	String expectedTitleRegister = "Sign Up";
    assertEquals(expectedTitleRegister, actualTitleRegister, "The actual and expected title don't match");

    String email = "m@m";
    String password = "123456";

    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("first-name")).sendKeys("Mari");
    driver.findElement(By.id("last-name")).sendKeys("Maasikas");
    driver.findElement(By.id("address")).sendKeys("Marja 1");
    driver.findElement(By.id("birth-date")).sendKeys("01-01-2000");

    driver.findElement(By.id("sign-up")).click();

    String actualTitleRegistrationSuccess = driver.getTitle();
    System.out.println("The title of the webpage:  " + actualTitleRegistrationSuccess);
	String expectedTitleRegistrationSuccess = "Registration Success";
    assertEquals(expectedTitleRegistrationSuccess, actualTitleRegistrationSuccess, "The actual and expected title don't match");



    // Login
    driver.findElement(By.id("user-login")).click();
    driver.findElement(By.id("username")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.linkText("Sign in")).click();

    String actualTitleUser = driver.getTitle();
    System.out.println("The title of the webpage:  " + actualTitleUser);
	String expectedTitleUser = "User";
    assertEquals(expectedTitleUser, actualTitleUser, "The actual and expected title don't match");



    // Check currency page and logout
    driver.findElement(By.id("currency")).click();

    String actualTitleCurrency = driver.getTitle();
    System.out.println("The title of the webpage:  " + actualTitleCurrency);
	String expectedTitleCurrency = "Currency Page";
    assertEquals(expectedTitleCurrency, actualTitleCurrency, "The actual and expected title don't match");

    //TODO Add currency converter check here

    driver.findElement(By.id("logout")).click();



    // Check all customers page and logout
    driver.findElement(By.className("all-users")).click();
    driver.findElement(By.id("username")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.linkText("Sign in")).click();

    String actualTitleUsers = driver.getTitle();
    System.out.println("The title of the webpage:  " + actualTitleUsers);
	String expectedTitleUsers = "Users";
    assertEquals(expectedTitleUsers, actualTitleUsers, "The actual and expected title don't match");

    driver.findElement(By.id("logout")).click();
      
    driver.quit();
    }  
}  
