package api;

import io.restassured.response.Response;
import pojo.UserLogin;
import specs.LoginPostSpecf;

import static io.restassured.RestAssured.given;

public class PostLogin {
    public static Response postApiCall(UserLogin postRequestPayload, String path){
        return  given().spec(LoginPostSpecf.loginPostRequestSpec())
                .body(postRequestPayload)
                .when()
                .post(path)
                .then().spec(LoginPostSpecf.loginPostResponseSpec())
                .extract().response();
    }
}