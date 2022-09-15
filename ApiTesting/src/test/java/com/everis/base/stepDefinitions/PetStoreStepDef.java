package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {

    @Steps
    PetStoreStep petStore;


    @Given("la URL del API {string}")
    public void laURLDelAPI(String arg0) {
        
    }

    @When("consulto la mascota de ID {string}")
    public void consultoLaMascotaDeID(String id) {
        petStore.consultaMascota(id);
    }

    @Then("valido el codigo de respuesta")
    public void validoElCodigoDeRespuesta() {
    }

    @And("muestro el body")
    public void muestroElBody() {
    }
}
