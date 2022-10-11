
import io.restassured.RestAssured;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class loginapi {
   private static String requestBody = "\"email\": \"test@gds.ey.com\"," +
           "\"password\": \"12345678\"";

    @BeforeTest
    public  static void setup() {
     RestAssured.baseURI = "https://simpleemployeerestapi.azurewebsites.net/api";
 }

    @Test
    public void postRequest() {
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .extract().response();


        //System.out.print("Response " + response.asPrettyString());

       // Assert.assertEquals(201, response.statusCode());
       // Assert.assertEquals("isAAuth", response.jsonPath().getString("isAuth"));
       // Assert.assertEquals("id", response.jsonPath().getString("id"));

    }
 }

