package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class EmpSpecs {
    public static RequestSpecification AddEmpRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://simpleemployeerestapi.azurewebsites.net/api")
                .addHeader("x-access-token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzNDNlMTI4OTEzNGZjNzdjZGIxODcxYiIsImlhdCI6MTY2NTU2NzQ1MywiZXhwIjoxNjY1NjAzNDUzfQ.jBNLhduDn449MY4yVUI8hT9CuZ3JdPpw3n0VcmrMjEM")
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


}