package api;

import io.restassured.response.Response;
import specs.GetEmpSpecs;

import static io.restassured.RestAssured.given;

public class GetAllEmp {
    public static Response getAllEmpcall(String path){
        return  given().spec(GetEmpSpecs.getEmpRequestSpec())
                .when()
                .get(path)
                .then().spec(GetEmpSpecs.getEmpResponseSpec())
                .extract().response();
    }
}
