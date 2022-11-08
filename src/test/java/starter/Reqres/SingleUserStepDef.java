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

public class SingleUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with parameter id {int}")
    public void getSingleUserWithParameterPage(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send get single user request")
    public void sendGetSingleUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }


    @Given("Get single user with invalid parameter id {string}")
    public void getSingleUserWithInvalidParameterId(String id) {
        reqresAPI.setGetSingleUserInvalid(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }


    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
