package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.MercadoLibreLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MercadoLibreStep {

    private WebDriver driver;

    //constructor
    public MercadoLibreStep(WebDriver driver){
        this.driver = driver;
    }

    public void ingresarUsuario(String user){
        WebElement userInputElement = driver.findElement(MercadoLibreLoginPage.txtUsuario);
        userInputElement.sendKeys(user);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(LoginPage.loginButton).click();
    }

}
