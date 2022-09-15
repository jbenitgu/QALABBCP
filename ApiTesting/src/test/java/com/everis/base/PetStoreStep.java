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
    static private final String BASE_URL = "https://reqres.in/api/";

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public void consultaMascota(String id){
        LOGGER.info("PRobando la consulta de Mascota");
    }


}
