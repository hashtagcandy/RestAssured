package api;

import io.restassured.response.Response;
import specs.DelEmpSpecs;
import specs.EmpSpecs;

import static io.restassured.RestAssured.given;

public class DelEmp {
    public static Response delEmpcall(String path){
        return  given().spec(DelEmpSpecs.delEmpRequestSpec())
                .when()
                .delete(path)
                .then().spec(DelEmpSpecs.delEmpResponseSpec())
                .extract().response();
    }
}
