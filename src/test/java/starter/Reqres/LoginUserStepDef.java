package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Login user with valid json")
    public void loginUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/LoginUser.json");
        reqresAPI.LoginUser(json);
    }
    @When("Send Login User Request")
    public void sendLoginUserRequest() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }
    @And("Response body should contain token {string}")
    public void responseBodyShouldContainToken(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Given("Post login user without password json")
    public void postLoginUserWithoutPasswordJson() {
        File json = new File(ReqresAPI.JSON_REQ_BODY+"/LoginUserInvalid.json");
        reqresAPI.LoginUser(json);
    }


}
