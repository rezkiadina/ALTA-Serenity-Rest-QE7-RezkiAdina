package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class SingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single resource with parameter id {int}")
    public void getSingleResourceWithParameterIdId (int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send get single resource request")
    public void sendGetSingleResourceRequest() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @Given("Get single resource with invalid parameter id {string}")
    public void getSingleResourceWithInvalidParameterId(String id) {
        reqresAPI.getSingleResourceInvalid(id);
    }

    @And("Validate get single resource json schema")
    public void validateGetSingleResourceJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetSingleResourceJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
