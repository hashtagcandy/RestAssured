package bodypojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;


public class loginapi2 {

    @Test
    public void createUserTest() {
        bdy obj = new bdy();
        obj.setEmail("soumadeep.roy@gds.ey.com");
        obj.setPassword("12345678");

        RestAssured.baseURI = "https://simpleemployeerestapi.azurewebsites.net/api";

        String payload = "{\r\n" +
                "  \"email\": \"test@gds.ey.com\",\r\n" +
                "  \"password\": \"12345678\"\r\n" +
                "}";

        RequestSpecification httpRequest = given();

        httpRequest.header("Content-Type","application/json");

        Response response = httpRequest.body(obj).post("/login");


        String statussw = response.asPrettyString();
        System.out.println(statussw);

        int statusCode = response.getStatusCode();
        System.out.println("Response status code is "+statusCode);

    }

}