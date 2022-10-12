package api;

import io.restassured.response.Response;
import pojo.req;
import specs.specf;

import static io.restassured.RestAssured.given;

public class put {
    public static Response putApiCall(req putRequestPayload, String path){
        return  given().spec(specf.putRequestSpec())
                .body(putRequestPayload)
                .when()
                .put(path)
                .then().spec(specf.putResponseSpec())
                .extract().response();
    }
}