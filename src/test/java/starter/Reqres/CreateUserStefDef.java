package starter.Reqres;
import io.restassured.module.jsv.JsonSchemaValidator;
import starter.Reqres.ReqresAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStefDef {
    @Steps
    ReqresAPI reqresAPI;

    //Latihan
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/CreateUser.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send post create user request")
    public void sendPostCreateUserRequest() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate post create user json schema")
    public void validatePostCreateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PostCreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
