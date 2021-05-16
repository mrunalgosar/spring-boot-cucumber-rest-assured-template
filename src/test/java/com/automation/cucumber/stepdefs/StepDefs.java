package com.automation.cucumber.stepdefs;

import com.springbootpractise.models.Session;
import com.springbootpractise.models.Speaker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.*;

public class StepDefs {

    private String baseUrl = "http://localhost:8080/api/v1/";
    private Speaker speaker;
    private Session session;

    @Given("user creates a speaker with following details")
    public void createUser(String speaker) {
        Response response = given().contentType(ContentType.JSON).when().body(speaker).post(baseUrl + "speakers").thenReturn();
        assertThat(response.getBody().print(), response.getStatusCode(), is(HttpStatus.SC_CREATED));
        this.speaker = response.getBody().as(Speaker.class);
    }

    @Then("user deletes speaker with name as {string}")
    public void deleteSpeaker(String name) {
        Response response = given().contentType(ContentType.JSON).queryParam("firstName", name).when().delete(baseUrl + "speakers").thenReturn();
        assertThat(response.getStatusCode(), is(200));
    }

    @Given("user creates a session with following details")
    public void createSession(String session) {
        Response response = given().contentType(ContentType.JSON).when().body(session).post(baseUrl + "sessions").thenReturn();
        assertThat(response.getBody().print(), response.getStatusCode(), is(HttpStatus.SC_CREATED));
        this.session = response.getBody().as(Session.class);
    }

    @Then("user deletes session with name as {string}")
    public void deleteSession(String sessionName) {
        Response response = given().contentType(ContentType.JSON).queryParam("name", sessionName).when().delete(baseUrl + "sessions").thenReturn();
        assertThat(response.getStatusCode(), is(200));
    }
}
