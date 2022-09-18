package com.homework;
  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
  
public class SeleniumTest {

    public static void main(String[] args) {  
         
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");  
    WebDriver driver = new ChromeDriver();
      
    // Launch website  
    driver.navigate().to("http://localhost:8080/");

    // Click on the register button  
    driver.findElement(By.className("register")).click();  

    driver.findElement(By.id("email")).sendKeys("m@m");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("first-name")).sendKeys("Mari");
    driver.findElement(By.id("last-name")).sendKeys("Maasikas");
    driver.findElement(By.id("address")).sendKeys("Marja 1");
    driver.findElement(By.id("birth-date")).sendKeys("01-01-2000");

    driver.findElement(By.id("sign-up")).click();

    /* 
    driver.findElement(By.id("user-login")).click();
    driver.findElement(By.id("username")).sendKeys("m@m");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.className("btn btn-lg btn-primary btn-block")).click();  

    driver.findElement(By.id("currency")).click();
    driver.findElement(By.id("logout")).click();

    driver.findElement(By.className("all-users")).click();
    */

    driver.navigate().to("http://localhost:8080/");
      
    }  
}  
