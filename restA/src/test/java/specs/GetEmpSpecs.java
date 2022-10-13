package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import test.GetEmpOperation;
import test.LoginPostOperation;

public class GetEmpSpecs {
    public static RequestSpecification getEmpRequestSpec(){
        GetEmpOperation tokenObj = new GetEmpOperation();
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
    public static ResponseSpecification getNegEmpidResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(404)
                .log(LogDetail.ALL)
                .build();
    }
    public static RequestSpecification getEmpNegTokenRequestSpec(){

        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .addHeader("x-access-token","invalidToken")
                .setContentType("application/json")
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getNegEmptokenResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(401)
                .log(LogDetail.ALL)
                .build();
    }
}
