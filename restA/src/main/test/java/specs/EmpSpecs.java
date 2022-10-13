package specs;
import test.LoginPostOperation;
import test.LoginPostOperation.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EmpSpecs {
    public static RequestSpecification AddEmpRequestSpec(){
        LoginPostOperation obj = new LoginPostOperation();


        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .addHeader("x-access-token",obj.triggerToken())
                .setContentType("application/json")
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL)
                .build();
    }
    public static RequestSpecification AddEmpNegRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .addHeader("x-access-token","wrong token")
                .setContentType("application/json")
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL)
                .build();
    }



    public static ResponseSpecification AddEmpResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification AddEmpNegTokenResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(401)
                .log(LogDetail.ALL)
                .build();
    }


}