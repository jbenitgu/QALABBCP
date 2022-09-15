package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.MercadoLibreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreStepDef {

    private WebDriver driver;
    private Scenario scenario;

    private MercadoLibreStep mercadoLibre;


    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();

    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }


    @Given("estoy en la pagina web {string}")
    public void estoyEnLaPaginaWeb(String arg0) {
        driver.get(arg0);
        mercadoLibre = new MercadoLibreStep(driver);
        screenShot();
    }


    @And("clic en Continuar")
    public void clicEnContinuar() {
    }


    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @When("ingresar el usuario {string}")
    public void ingresarElUsuario(String usuario) {
        mercadoLibre.ingresarUsuario(usuario);
        screenShot();
    }
}
