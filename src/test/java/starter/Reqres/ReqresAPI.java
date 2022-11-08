package starter.Reqres;

import io.restassured.http.ContentType;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import java.io.File;

public class ReqresAPI {
    public static final String URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQ_BODY = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";
    public static String GET_SINGLE_USER =URL+"/api/users/{id}";
    public static String POST_REGISTER_USER = URL+"/api/register";
    public static String PATCH_UPDATE_USER = URL+"/api/users/{id}";
    public static String LOGIN_USER = URL+"/api/login";
    public static String LIST_RESOURCE = URL+"/api/unknown";
    public static String GET_SINGLE_RESOURCE = URL+"/api/unknown/{id}";

    @Step ("Get list users invalid")
    public void getListUsers (int page){
        SerenityRest.given().pathParams("page", page);
    }
    @Step ("Get list resource")
    public void getListResource (int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step ("Get single user invalid")
    public void setGetSingleUserInvalid (String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single resource")
    public void getSingleResource (int id){
        SerenityRest.given().pathParams("id", id);
    }
    @Step ("Get single resource invalid")
    public void getSingleResourceInvalid (String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Post register user")
    public void postRegisterUser (File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step ("Put update user")
    public void putUpdateUser (int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete User")
    public void deleteUser (int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Login User")
    public void LoginUser(File json){
        SerenityRest.given().
                contentType(ContentType.JSON).
                body(json);
    }

}
