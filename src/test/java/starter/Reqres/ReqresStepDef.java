package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.postcodes.PostCodeAPI;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //SKenario 1
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send get list user request")
    public void sendGetListUserRequest() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/GetListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Skenario 3
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }
    @When("Send put update user request")
    public void sendPutUpdateUserRequest() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    //Skenario 4
    @Given("Delete user with id {int}")
    public void deleteUserWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user request")
    public void sendDeleteUserRequest() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent){
        SerenityRest.then().statusCode(noContent);
    }


}
