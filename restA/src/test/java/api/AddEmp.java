package api;



import io.restassured.response.Response;

import pojo.EmpPojo;
import specs.EmpSpecs;

import static io.restassured.RestAssured.given;

public class AddEmp {
    public static Response addEmpcall(EmpPojo postRequestPayload, String path){
        return  given().spec(EmpSpecs.AddEmpRequestSpec())
                .body(postRequestPayload)
                .when()
                .post(path)
                .then().spec(EmpSpecs.AddEmpResponseSpec())
                .extract().response();
    }
}