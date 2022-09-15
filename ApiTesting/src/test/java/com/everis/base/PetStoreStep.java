package com.everis.base;

import com.everis.base.models.Book;
import com.everis.base.models.User;
import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreStep {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetStoreStep.class);
    static private String BASE_URL = "";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request** ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build()

        ;

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public void consultaMascota(String id){
        LOGGER.info("consultaMascota inicio");

        given().
                baseUri(BASE_URL).
                //spec(requestSpec).
                log().all().
                when().
                get("pet/" + id).
                then().
                //spec(responseSpec).
                and()
                .log().all()
        ;

        LOGGER.info("consultaMascota Fin");



    }

    public void setearURLBase(String url){
        BASE_URL = url;
    }

    public void validaCodigoRespuesta(int statusCode){
        assertThat(lastResponse().statusCode(), is(statusCode));
    }

    public void validarNombreMascota(String nombre){
        LOGGER.info("inicio validacion de masctora");
        assertThat(lastResponse().getBody().path("name"), equalTo(nombre));
        LOGGER.info("fin de validacion de masctora");
    }

    public void crearMascota(String nombre, int id){

        JsonObject parametros = new JsonObject();
        parametros.addProperty("id", id);
        parametros.addProperty("name", nombre);

        bodyPost = parametros.toString();

        given().
                baseUri(BASE_URL).
                log().all().
                when().
                contentType("application/json").
                body(bodyPost).
                /*body("{\n" +
                                "  \"id\": "+ id + ",\n" +
                                "  \"name\": \"\"+ nombre + \"\"\n" +
                                "}").*/
                post("pet").
                then().
                and()
                .log().all();
    }


}
