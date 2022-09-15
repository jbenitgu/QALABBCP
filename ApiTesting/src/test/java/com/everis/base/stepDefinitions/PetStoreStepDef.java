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
    public void laURLDelAPI(String url) {
        petStore.setearURLBase(url);
    }

    @When("consulto la mascota de ID {string}")
    public void consultoLaMascotaDeID(String id) {
        petStore.consultaMascota(id);
    }


    @Then("valido el codigo de respuesta {int}")
    public void validoElCodigoDeRespuesta(int statusCode) {
        petStore.validaCodigoRespuesta(statusCode);
    }




    @And("el nombre de la mascota sea {string}")
    public void elNombreDeLaMascotaSea(String nombre) {
        petStore.validarNombreMascota(nombre);
    }

    @When("creo la mascota de nombre {string} con el id {int}")
    public void creoLaMascotaDeNombreConElId(String arg0, int arg1) {
        petStore.crearMascota(arg0,arg1);
    }
}
