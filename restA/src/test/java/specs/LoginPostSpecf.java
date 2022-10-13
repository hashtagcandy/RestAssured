package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LoginPostSpecf {
    public static RequestSpecification loginPostRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .setContentType("application/json")
                .setRelaxedHTTPSValidation()
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification loginPostResponseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }


}