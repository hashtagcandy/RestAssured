package api;

import io.restassured.response.Response;
import pojo.EmpPojo;
import specs.EmpSpecs;
import specs.GetEmpSpecs;

import static io.restassured.RestAssured.given;

public class GetEmp {
    public static Response getEmpcall( String path){
        return  given().spec(GetEmpSpecs.getEmpRequestSpec())
                .when()
                .get(path)
                .then().spec(GetEmpSpecs.getEmpResponseSpec())
                .extract().response();
    }
    public static Response getNegEmpIdcall( String path){
        return  given().spec(GetEmpSpecs.getEmpRequestSpec())
                .when()
                .get(path)
                .then().spec(GetEmpSpecs.getNegEmpidResponseSpec())
                .extract().response();
    }
    public static Response getNegEmpTokencall( String path){
        return  given().spec(GetEmpSpecs.getEmpNegTokenRequestSpec())
                .when()
                .get(path)
                .then().spec(GetEmpSpecs.getNegEmptokenResponseSpec())
                .extract().response();
    }
}
