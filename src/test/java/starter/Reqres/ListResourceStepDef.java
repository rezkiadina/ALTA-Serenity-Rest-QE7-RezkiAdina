package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

public class ListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resource")
    public void getListResource(int page) {
        reqresAPI.getListResource(page);
    }
    @Given("Get list resource with parameter id {int}")
    public void getListResourceWithParameterId(int id) {
  //      reqresAPI.getListResource(id);
    }
    @When("Send get list resource request")
    public void sendGetListResourceRequest() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }


}
