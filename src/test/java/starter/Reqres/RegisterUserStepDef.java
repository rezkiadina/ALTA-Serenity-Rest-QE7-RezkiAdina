package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.postcodes.PostCodeAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterUser.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send post register request")
    public void sendPostRegisterRequest() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body should contain id {int} and token {string}")
    public void responseBodyShouldContainIdAndToken(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Given("Post register user without password json")
    public void postRegisterUserWithoutPasswordJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/RegisterUserInvalid.json");
        reqresAPI.postRegisterUser(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR,equalTo(error));
    }
}
