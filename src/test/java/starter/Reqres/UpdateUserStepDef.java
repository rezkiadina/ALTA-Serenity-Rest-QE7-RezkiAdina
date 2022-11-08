package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user with valid json with id {int}")
    public void patchUpdateUserWithValidJson(int id) {
        File json = new File(ReqresAPI.JSON_REQ_BODY + "/UpdateUserPatch.json");
        reqresAPI.patchUpdateUser(id, json);
    }

    @When("Send patch update user request")
    public void sendPatchUpdateUserRequest() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @And("Validate put update user json schema")
    public void validatePutUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PutUpdateJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate patch update user json schema")
    public void validatePatchUpdateUserJsonSchema() {
        File json = new File(ReqresAPI.JSON_SCHEMA+"/PatchUpdateJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
