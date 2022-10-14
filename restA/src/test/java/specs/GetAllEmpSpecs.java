package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import test.GetAllEmpOperation;
import test.GetEmpOperation;

public class GetAllEmpSpecs {
    public static RequestSpecification getAllEmpRequestSpec(){
        GetAllEmpOperation tokenObj = new GetAllEmpOperation();
        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .addHeader("x-access-token",tokenObj.triggerToken())
                .setContentType("application/json")
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL)
                .build();
    }
    public static ResponseSpecification getEmpResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }
    public static ResponseSpecification getNegEmpResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(401)
                .log(LogDetail.ALL)
                .build();
    }
}

