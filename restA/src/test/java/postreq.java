import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.UserLogin;

import static io.restassured.RestAssured.given;

public class postreq {
    UserLogin obj= new UserLogin();
    @BeforeClass
    public void baseURI()
    {

        RestAssured.baseURI="https://simpleemployeerestapi.azurewebsites.net/api/login";
    }
    @Test
    public void postNegEmail()
    {

        obj.setEmail("xyz.roy@gds.ey.com");
        obj.setPassword("12345678");
        given()
                .relaxedHTTPSValidation().header("Content-type","application/json")
                .log().all()
                .body(obj)
                .when().post().then()
                .statusCode(401)
                .log().all();
    }
    @Test
    public void postNegPass()
    {
        // user obj= new user();
        obj.setEmail("soumadeep.roy@gds.ey.com");
        obj.setPassword("jefjeiof");
        given()
                .relaxedHTTPSValidation().header("Content-type","application/json")
                .log().all()
                .body(obj)
                .when().post().then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void createUserFromPojo()
    {
        //RestAssured.baseURI="https://simpleemployeerestapi.azurewebsites.net/api/login";

        // user obj= new user();
        obj.setEmail("soumadeep.roy@gds.ey.com");
        obj.setPassword("12345678");

        given()
                .relaxedHTTPSValidation().header("Content-type","application/json")
                .log().all()
                .body(obj)
                .when().post().then()
                .statusCode(200)
                .log().all();
    }

}